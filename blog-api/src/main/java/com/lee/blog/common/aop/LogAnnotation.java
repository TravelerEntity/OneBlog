package com.lee.blog.common.aop;

import java.lang.annotation.*;

/**
 * Created by Lee Yian on 2023/4/23 15:09
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    String module() default "";
    String operation() default "";
}
