package com.lee.blog.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lee.blog.admin.mapper.AdminMapper;
import com.lee.blog.admin.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lee Yian on 2023/5/1 17:36
 * admit 相关 service
 */
@Service
public class AdminService {
    private final AdminMapper adminMapper;

    @Autowired
    public AdminService(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    /**
     * 通过 username 查找对应的 admin
     * @param username 用户名
     * @return Admin
     */
    public Admin findAdmitByUsername(String username) {
        LambdaQueryWrapper<Admin> query = new LambdaQueryWrapper<>();
        // 设定查询条件
        query.eq(Admin::getUsername, username).last("limit 1");
        return adminMapper.selectOne(query);
    }
}
