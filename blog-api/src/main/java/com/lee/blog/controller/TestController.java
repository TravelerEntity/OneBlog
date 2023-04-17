package com.lee.blog.controller;

import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.SysUser;
import com.lee.blog.utils.UserThreadLocal;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
    
/**
 * Created by Lee Yian on 2023/4/10 19:38
 */
@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    @RequestMapping
    public R test(){
        SysUser user = UserThreadLocal.get();
        log.info(String.valueOf(user));
        return R.success(null);
    }
}
