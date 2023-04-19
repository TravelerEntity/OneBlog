package com.lee.blog.service;

import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.vo.params.LoginParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Lee Yian on 2023/4/5 20:35
 */

@Transactional
public interface LoginService {

    /**
     * 执行登录操作
     * @param loginParam 登录参数的封装, account, password
     * @return R token
     */
    R login(LoginParam loginParam);

    /**
     * 检查 token 是否合法，如果合法且存在于 Redis 中，就返回 Redis 对应的用户
     * @param token token
     * @return SysUsr Json 格式
     */
    String checkToken(String token);

    /**
     * 退出登录，删除 redis 中 token
     * @param token 登录 token
     * @return R null
     */
    R logout(String token);


    /**
     * 用户注册
     * @param loginParam aka 注册参数，登录参数
     * @return R token
     */
    R register(LoginParam loginParam);
}
