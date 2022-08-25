package com.sanguo.springboot.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class NoticeListener implements ApplicationListener<NoticeEvent> {

    private static final Logger logger = LoggerFactory.getLogger(NoticeListener.class);

    @Override
    public void onApplicationEvent(NoticeEvent noticeEvent) {
        logger.info("receive event message is : {}", noticeEvent.getMessage());
    }
}