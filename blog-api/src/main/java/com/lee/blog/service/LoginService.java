package com.lee.blog.service;

import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.SysUser;
import com.lee.blog.dao.pojo.vo.LoginParam;

/**
 * Created by Lee Yian on 2023/4/5 20:35
 */
public interface LoginService {

    /**
     * 执行登录操作
     * @param loginParam 登录参数的封装, account, password
     * @return R
     */
    R login(LoginParam loginParam);

    /**
     * 检查 token 是否合法，redis 中是否存在
     * @param token token
     * @return SysUsr Json 格式
     */
    String checkToken(String token);

    /**
     * 退出登录，删除 redis 中 token
     * @param token 登录 token
     * @return R
     */
    R logout(String token);
}
