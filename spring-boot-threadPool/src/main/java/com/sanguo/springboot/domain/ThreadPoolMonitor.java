package com.sanguo.springboot.domain;

import com.sanguo.springboot.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ThreadPoolMonitor {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Resource(name = "stepAsyncExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Scheduled(fixedDelay = 100)
    public void pintPoolData() {
        logger.info("active count = {}",threadPoolTaskExecutor.getActiveCount());
    }
}
