package com.lee.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by Lee Yian on 2023/4/17 16:42
 * 线程池配置
 * <a href="https://www.jianshu.com/p/0b8443b1adc9">关于@Configuration和@Bean的用法和理解</a>
 */

@Configuration
// 开启多线程
@EnableAsync
public class ThreadPoolConfig {

    @Bean("taskExecutor")
    public Executor asyncServiceExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // set pool size
        executor.setCorePoolSize(5);
        // set max pool size
        executor.setMaxPoolSize(20);
        // set queue capacity
        executor.setQueueCapacity(Integer.MAX_VALUE);
        // set thread's active time(second)
        executor.setKeepAliveSeconds(60);
        // set thread name prefix
        executor.setThreadNamePrefix("Mszl_");
        // enable the pool to shut down till all tasks are competed
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }
}
