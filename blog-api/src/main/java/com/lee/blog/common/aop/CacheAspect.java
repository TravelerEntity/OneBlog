package com.lee.blog.common.aop;

import com.alibaba.fastjson.JSON;
import com.lee.blog.dao.pojo.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Lee Yian on 2023/4/24 22:20
 * Cache 切面 统一缓存处理
 */
@Aspect
@Component
@Slf4j
public class CacheAspect {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Pointcut("@annotation(com.lee.blog.common.aop.CacheAnnotation)")
    public void pt(){};


    @Around("pt()")
    public Object cache(ProceedingJoinPoint pjp) throws Throwable {
        /*
            1. 构造 redis key，key 由 类名+方法名+方法参数组成
            2. 用 key 去 redis 中取值
            2.1 如果没有，说明没有缓存，从数据库读取返回并存入 redis
            2.2 如果有，直接返回，不再执行查询方法
         */
        try{
            // jp = Joint Point = 切面命中的切点
            // 获取 jp 位置的签名（成员）， such as method, filed, constructor
            Signature signature = pjp.getSignature();
            // 获取 jp 位置的简单类名（simpleName 不含包名）
            String className = pjp.getTarget().getClass().getSimpleName();
            // 获取 jp 位置
            String methodName = signature.getName();
            // 参数类型的数组
            Class[] parameterTypes = new Class[pjp.getArgs().length];
            // 从 jp 获取所有的参数
            Object[] args = pjp.getArgs();
            StringBuilder builder = new StringBuilder();
            // 遍历 jp 的传入的参数，组合成一个 json 格式的数组，然后用每个参数的参数类型组成一个 参数类型数组（parameterTypes）
            for (int i = 0; i < args.length; i++) {
                if(args[i] != null){
                    builder.append(JSON.toJSONString(args[i]) );
                    parameterTypes[i] = args[i].getClass();
                } else {
                    parameterTypes[i] = null;
                }
            }
            String paraString = builder.toString();
            // 用 md5 加密参数，还可以起到组织特殊字符被转码的作用
            if(StringUtils.isNotEmpty(paraString) ){
                paraString = DigestUtils.md5Hex(paraString);
            }
            // 获取 jp 的方法（需要传入方法名，和参数表类型），这一步是为了下面获取方法上的注解
            Method method = signature.getDeclaringType().getMethod(methodName, parameterTypes);

            // 获取 jp 位置的注解，和它的相关信息
            CacheAnnotation annotation = method.getAnnotation(CacheAnnotation.class);
            long expire = annotation.expireTime();  // 获取注解预设的有效期
            String annoName = annotation.name();    // 获取注解的 name 属性

            // 构建 redis key
            String redisKey = annoName + "::" + className + "::" + methodName + "::" + paraString;
            // 从 redis 读取
            String redisValue = redisTemplate.opsForValue().get(redisKey);

            // 如果 redisValue 不为空，缓存有这个数据，用 JSON 解析后直接返回
            if(StringUtils.isNotEmpty(redisValue) ){
                log.info("从缓存返回；{}, {}",className, methodName);
                // 将 redisValue 解析成 R.class 对象返回
                return JSON.parseObject(redisValue, R.class);
            }
            // 如果 redisValue 没有，就执行方法返回
            Object proceedResult = pjp.proceed();
            // 存入 redis
            redisTemplate.opsForValue().set(redisKey, JSON.toJSONString(proceedResult), Duration.ofMillis(expire) );
            log.info("存入缓存{},{}",className, methodName);
            return proceedResult;
        } catch (Throwable throwable){
            throwable.printStackTrace();
        }

        return R.fail(-999,"系统错误~");
    }

}
