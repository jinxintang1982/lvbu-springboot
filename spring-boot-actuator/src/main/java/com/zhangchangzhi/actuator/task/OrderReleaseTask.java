package com.zhangchangzhi.actuator.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: zhangchangzhi
 * @create: 2020-07-22 17:00
 **/
@Component
public class OrderReleaseTask {
    @Scheduled(cron = "0 0 1 * * ?")
    public void cronJob(){
        //每1秒，执行一次，cron表达式
    }

    @Scheduled(fixedDelay = 2  * 1000)
    public void fixedDelayJob(){
        //每2秒，执行一次，固定间隔
    }

    @Scheduled(fixedRate = 3 * 1000)
    public void fixedRateJob(){
        //每3秒，执行一次，固定频率
    }
}
