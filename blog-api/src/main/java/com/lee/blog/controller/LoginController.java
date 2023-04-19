package com.lee.blog.controller;

import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.vo.params.LoginParam;
import com.lee.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lee Yian on 2023/4/5 20:27
 */
@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    LoginService loginService;

    /*  不建议通过 userService 直接进行登录操作,
        sysUserService 应该只负责对 sysUserService 进行 crud
        登录功能则是另外一个服务, 降低耦合
     */

    /**
     * 执行登录操作
     * @param loginParam 登录参数的封装, account str, password str
     * @return R
     */
    @PostMapping()
    public R login(@RequestBody LoginParam loginParam){
        return loginService.login(loginParam);
    }
}
