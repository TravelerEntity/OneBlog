package com.lee.blog.controller;

import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.vo.LoginParam;
import com.lee.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lee Yian on 2023/4/9 20:12
 */
@RestController
@RequestMapping("register")
public class RegisterController {

    @Autowired
    LoginService loginService;

    @PostMapping
    public R register(@RequestBody LoginParam loginParam) {
        return loginService.register(loginParam);
    }
}
