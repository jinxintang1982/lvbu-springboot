package com.sanguo.springboot.domain;

import com.sanguo.springboot.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AsyncStepServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);




    @Async("stepAsyncExecutor")
    public void exeStepAsync() {
        logger.info("exeStepAsync exe thread begin ");
        try{
            long sleepLength = Math.round(Math.random()* 1000L);
            Thread.sleep(sleepLength ) ;
            logger.info("exeStepAsync exe thread end {} 毫秒: ",sleepLength );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
