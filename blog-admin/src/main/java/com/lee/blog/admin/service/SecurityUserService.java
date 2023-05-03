package com.lee.blog.admin.service;

import com.lee.blog.admin.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Lee Yian on 2023/5/1 17:34
 * 登陆验证
 */
@Component
public class SecurityUserService implements UserDetailsService {
    private final AdminService adminService;

    @Autowired
    public SecurityUserService(AdminService adminService){
        this.adminService = adminService;
    }

    // 实现方法，加载从数据库
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 当用户登录的时候，springSecurity 就会将请求 转发到此
        // 根据用户名 查找用户，不存在 抛出异常，存在 将用户名，密码，授权列表 组装成springSecurity的User对象 并返回
        // Spring security 会自动验证密码
        Admin admin = adminService.findAdmitByUsername(username);

        if (admin == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        // 加载完登录用户后，会进入下一个流程，权限验证
        return new User(username, admin.getPassword(), authorities);
    }
}
