package com.lee.blog.service;

import com.lee.blog.dao.pojo.SysUser;

/**
 * Created by Lee Yian on 2023/4/4 21:41
 */
public interface SysUserService {
    SysUser findUserById(Long id);
}
