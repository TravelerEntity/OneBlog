package com.lee.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Lee Yian on 2023/4/4 16:03
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 跨域配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许服务器的所有资源被另一个域 localhost:8081 访问
        registry.addMapping("/**").allowedOrigins("http://localhost:8081","http://localhost:8080");
    }
}
