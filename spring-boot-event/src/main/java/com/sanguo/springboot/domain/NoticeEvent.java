package com.sanguo.springboot.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

public class NoticeEvent extends ApplicationEvent {

    private static final Logger logger = LoggerFactory.getLogger(NoticeEvent.class);
    /**
     * 接受信息
     */
    private String message;

    public NoticeEvent(String message) {
        super(message);
        this.message = message;
        logger.info("create event success! message: {}", message);
    }

    public String getMessage() {
        return message;
    }
}