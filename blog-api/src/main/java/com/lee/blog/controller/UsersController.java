package com.lee.blog.controller;

import com.lee.blog.dao.pojo.R;
import com.lee.blog.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lee Yian on 2023/4/9 16:40
 */

@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    SysUserService sysUserService;

    @GetMapping("currentUser")
    public R currentUser(@RequestHeader("Authorization") String token){
        return sysUserService.findUserByToken(token);
    }
}
