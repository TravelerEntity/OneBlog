package com.lee.blog.common.aop;

import java.lang.annotation.*;

/**
 * Created by Lee Yian on 2023/4/24 21:18
 * 缓存 aop
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheAnnotation {
    // 缓存过期时间，默认一分钟
    long expireTime() default 60 * 1000L; // 1 * 60 * 1000

    // 缓存对应的方法名，标识缓存
    String name() default "";
}
