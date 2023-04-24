package com.lee.blog.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Lee Yian on 2023/4/23 15:30
 * 用去当前线程（请求）的 HttpServletRequest 对象
 * RequestContextHolder 是 spring 框架中用于在多线程中访问特定线程的对象
 * 它持有一个 threadLocal 对象，所以它能返回当前请求的对象
 *
 */
public class HttpContextUtils {

    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
