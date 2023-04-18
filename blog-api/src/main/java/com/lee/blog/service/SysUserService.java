package com.lee.blog.service;

import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.SysUser;
import com.lee.blog.dao.pojo.vo.UserVo;

/**
 * Created by Lee Yian on 2023/4/4 21:41
 */
public interface SysUserService {

    /**
     * 通过用户 id 查找用户
     * @param id 用户 id
     * @return SysUser
     */
    SysUser findUserById(Long id);

    /**
     * 在登录时使用，通过账号密码查找用户
     * @param account 账户
     * @param password 密码
     * @return SysUser
     */
    SysUser findUser(String account, String password);

    /**
     * 通过 token 返回当前登录的用户信息
     * @param token token
     * @return R
     */
    R findUserByToken(String token);

    /**
     * 通过账号查找用户
     * @param account 账号
     * @return SysUser
     */
    SysUser findUserByAccount(String account);

    /**
     * 持久化用户
     * @param sysUser sysUser
     */
    void save(SysUser sysUser);

    /**
     * 通过 userId 查找 UserVO
     * @param userId userId
     * @return UserVo
     */
    UserVo findUserVoById(Long userId);
}
