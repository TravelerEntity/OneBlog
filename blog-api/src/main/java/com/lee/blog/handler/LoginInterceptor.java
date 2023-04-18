package com.lee.blog.handler;

import com.alibaba.fastjson.JSON;
import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.SysUser;
import com.lee.blog.dao.pojo.vo.ErrorCode;
import com.lee.blog.service.LoginService;
import com.lee.blog.utils.UserThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Lee Yian on 2023/4/10 17:22
 * 登录拦截器
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*
            登录校验
            1. 先判断是否属于 Controller 的方法
            2. 判断是否有 token，以及 token 是否有效
                2.1 如果无效，通过 response 写入返回值
                2.2 token 有效，就 return true 放行
         */
        if( !(handler instanceof HandlerMethod)){
            // 如果是访问静态资源，就直接 return true
            return true;
        }
        String token = request.getHeader("Authorization");

        // 输出日志
        log.info("=================request start===========================");
        String requestURI = request.getRequestURI();
        log.info("request uri:{}",requestURI);
        log.info("request method:{}",request.getMethod());
        log.info("token:{}", token);
        log.info("=================request end===========================");

        // 非空校验
        if(StringUtils.isBlank(token) ){        // token 无效，return false
            R result = R.fail(ErrorCode.NO_LOGIN.getCode(), ErrorCode.NO_LOGIN.getMsg());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        // token 有效性校验
        String userJSON = loginService.checkToken(token);
        if(StringUtils.isBlank(userJSON) ){     // token 无效，return false
            R result = R.fail(ErrorCode.NO_LOGIN.getCode(), ErrorCode.NO_LOGIN.getMsg());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        // 走到这一步，有效，return true 放行

        // 保存对象进 ThreadLocal
        SysUser sysUser = JSON.parseObject(userJSON,SysUser.class);
        UserThreadLocal.put(sysUser);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        // 用完之后清除线程的 ThreadLocal 信息，避免内存溢出
        UserThreadLocal.remove();
    }
}
