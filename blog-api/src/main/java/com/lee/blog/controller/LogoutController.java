package com.lee.blog.controller;

import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.vo.LoginParam;
import com.lee.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lee Yian on 2023/4/9 18:09
 */

@RestController
@RequestMapping("logout")
public class LogoutController {
    @Autowired
    LoginService loginService;

    @GetMapping()
    public R login(@RequestHeader("Authorization") String token){
        return loginService.logout(token);
    }
}
