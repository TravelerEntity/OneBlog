package com.lee.blog.admin.service;

import com.lee.blog.admin.mapper.AdminMapper;
import com.lee.blog.admin.pojo.Admin;
import com.lee.blog.admin.pojo.Permission;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Lee Yian on 2023/5/1 19:49
 * 权限认证，在登录验证之后执行
 */

@Service
@Slf4j
public class AuthService {
    private final AdminMapper adminMapper;

    private final AdminService adminService;

    @Autowired
    public AuthService(AdminMapper adminMapper, AdminService adminService) {
        this.adminMapper = adminMapper;
        this.adminService = adminService;
    }

    public boolean auth(HttpServletRequest request, Authentication authentication){
        // 权限认证，先判断用户是否存在，再判断用户是否拥有访问本次资源的权限，没有就 return false
        // 获取请求路径
        String requestURI = request.getRequestURI();

        // principal 代表当前的用户，由上一级登录控制返回，在这里是 SecurityUserService.loadUserByUsername() 返回
        Object principal = authentication.getPrincipal();

        // 如果 principal 为空和 anonymousUser 代表未通过登录验证
        if(principal == null || "anonymousUser".equals(principal) ){
            return false;
        }
        UserDetails userDetails = (UserDetails) principal;

        // 查询管理员
        String username = userDetails.getUsername();
        Admin admin = adminService.findAdmitByUsername(username);

        if(admin == null ){
            return false;
        }
        // id 1 为 root 权限
        if(admin.getId() == 1){
            return true;
        }
        // 查询角色所拥有的操作权限
        List<Permission> permissionList = adminMapper.findPermissionListByAdminId(admin.getId() );
        requestURI = StringUtils.split(requestURI,"?")[0];

        // 如果本次请求的资源在该角色对应的权限中，就通过
        for (Permission permission : permissionList) {
            if (StringUtils.equals(requestURI, permission.getPath() ) ){
                log.info("用户{}访问了{}，认证通过",admin.getUsername(), requestURI);
                return true;
            }

        }
        log.info("用户{}访问了{}，认证失败",admin.getUsername(), requestURI);
        return false;
    }
}
