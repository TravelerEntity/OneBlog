package com.lee.blog.common.aop;

import com.alibaba.fastjson.JSON;
import com.lee.blog.utils.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by Lee Yian on 2023/4/23 15:14
 */
@Component
@Aspect     // 切面定义
@Slf4j
public class LogAspect {

    // 定义一个切点
    @Pointcut("@annotation(com.lee.blog.common.aop.LogAnnotation)")
    public void pt(){
    }


    @Around("pt()")
    public Object log(ProceedingJoinPoint jp) throws Throwable {
        long beginTime = System.currentTimeMillis();

        // 执行方法
        Object result = jp.proceed();

        // 计算执行时间
        long duration = System.currentTimeMillis() - beginTime;

        // 输出日志
        recordLog(jp,duration);

        return result;
    }

    private void recordLog(ProceedingJoinPoint jp, long duration) {
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        // 注解信息
        LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);
        log.info("=====================log start================================");
        log.info("module: {}",logAnnotation.module());
        log.info("operation: {}",logAnnotation.operation());

        // 方法信息
        String className = jp.getTarget().getClass().toString();
        String methodName = method.getName();
        log.info("request method: {}",className+ "."+methodName);

        // 方法参数信息
        Object[] args = jp.getArgs();
        String params = JSON.toJSONString(args);
        log.info("params: {}",params);

        // IP 信息
        log.info("ip: {}", IpUtils.getIpAddr());

        log.info("execute time : {} ms", duration);
        log.info("=====================log end================================");
    }
}
