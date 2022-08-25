package com.sanguo.springboot.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@Configuration
@EnableAsync
public class StepThreadPoolConfig {


    //让Spring容器管理返回的线程池对象，并起名"stepAsyncExecutor"
    @Bean("stepAsyncExecutor")
    public ThreadPoolTaskExecutor stepExecutor() {
        //定义线程池：
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        //设置核心线程数：
        threadPoolTaskExecutor.setCorePoolSize(50);
        //设置线程池最大线程数：
        threadPoolTaskExecutor.setMaxPoolSize(200);
        //设置线程（阻塞）队列最大线程数：
        threadPoolTaskExecutor.setQueueCapacity(100);
        //初始化线程池：
        threadPoolTaskExecutor.initialize();

        return threadPoolTaskExecutor;
    }

}
