package com.lee.blog.config;

import com.lee.blog.handler.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Lee Yian on 2023/4/4 16:03
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    LoginInterceptor loginInterceptor;

    // 跨域配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许服务器的所有资源被另一个域 localhost:8081 访问
        registry.addMapping("/**").allowedOrigins("http://localhost:8081","http://localhost:8080");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/test")   // '/**/ 则表示匹配拦截所有页面
                .addPathPatterns("/comments/create/change")     // 拦截添加评论
                .addPathPatterns("/articles/publish")     // 拦截发布文章
                ;
    }
}
