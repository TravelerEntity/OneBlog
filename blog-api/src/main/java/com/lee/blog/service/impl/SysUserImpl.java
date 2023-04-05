package com.lee.blog.service.impl;

import com.lee.blog.dao.mapper.SysUserMapper;
import com.lee.blog.dao.pojo.SysUser;
import com.lee.blog.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lee Yian on 2023/4/4 21:42
 */
@Service
public class SysUserImpl implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserById(Long id) {
        return sysUserMapper.selectById(id);
    }
}
