package com.lee.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.SysUser;
import com.lee.blog.dao.pojo.vo.ErrorCode;
import com.lee.blog.dao.pojo.vo.LoginParam;
import com.lee.blog.service.LoginService;
import com.lee.blog.service.SysUserService;
import com.lee.blog.utils.JWTUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * Created by Lee Yian on 2023/4/5 20:36
 */
@Service
public class LoginServiceImpl implements LoginService {

    // 固定加密盐
    private static final String salt = "Md5_password_salt_2023-04-09-15:18";

    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    SysUserService sysUserService;

    // 注入 redisTemplate
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Override
    public R login(LoginParam loginParam) {
        logger.info(loginParam);
        // 1. 先获取参数，校验是否合法
        String account = loginParam.getAccount();
        String password = loginParam.getPassword();
        if(StringUtils.isBlank(account) || StringUtils.isBlank(password) ){
            return R.fail(ErrorCode.PARAMS_ERROR.getCode(),ErrorCode.PARAMS_ERROR.getMsg());
        }
        // md5 加盐，不使用明文
        password = DigestUtils.md5Hex(password+salt);
        // 2. 执行查询，检查用户是否存在
        SysUser sysUser = sysUserService.findUser(account,password);
        // 2.1 不存在，返回错误提示
        if (sysUser == null){
            return R.fail(ErrorCode.ACCOUNT_PWD_NOT_EXISTS.getCode(), ErrorCode.ACCOUNT_PWD_NOT_EXISTS.getMsg());
        }
        // 2.2 存在，生成 token，token 放入 redis
        String token = JWTUtils.createToken(sysUser.getId());
        // JSON.toJSONString 用法     https://blog.csdn.net/antony9118/article/details/71023009
        // redisTemplate用法          https://blog.csdn.net/lydms/article/details/105224210
        redisTemplate.opsForValue().set("TOKEN_"+token, JSON.toJSONString(sysUser), 1, TimeUnit.DAYS);
        // 3. 登陆成功，返回 token
        return R.success(token);
    }

    @Override
    public String checkToken(String token) {
        if(StringUtils.isBlank(token) ){
            // token 格式错误返回 null
            return null;
        }
        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        if(stringObjectMap == null){
            // token 解密失败返回 null
            return null;
        }

        String userJson = redisTemplate.opsForValue().get("TOKEN_"+token);
        if(StringUtils.isBlank(userJson)){
            // redis 中不存在返回 null
            return null;
        }
        return userJson;
    }

    @Override
    public R logout(String token) {
        if(StringUtils.isBlank(token) ){
            // token 格式错误返回 null
            return R.fail(ErrorCode.PARAMS_ERROR.getCode(), ErrorCode.PARAMS_ERROR.getMsg());
        }
        // Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        // if(stringObjectMap == null){
        //     // token 解密失败返回 null
        //     return R.fail(ErrorCode.TOKEN_NOT_EXISTS.getCode(), ErrorCode.TOKEN_NOT_EXISTS.getMsg());
        // }

        redisTemplate.delete("TOKEN_"+token);
        return R.success(null);
    }
}
