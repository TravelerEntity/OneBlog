package com.lee.blog.handler;

import com.lee.blog.dao.pojo.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by Lee Yian on 2023/4/5 15:14
 * 统一异常处理
 * 从注解 @RestControllerAdvice 可以看出来这是基于 AOP 实现的功能
 * 它的返回数据同时也是 Json 格式，因为有 RestController
 */
@RestControllerAdvice
public class AllExceptionHandler {

    // 进行异常处理，参数表示处理 Exception 类型异常，namely all the exception
    @ExceptionHandler(Exception.class)
    public R doException(Exception ex){
        // 先在控制台输出一下，后面再保存到系统日志中
        ex.printStackTrace();
        return R.fail(-999,"哎呀，系统异常");
    }
}
