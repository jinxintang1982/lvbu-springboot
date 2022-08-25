package com.sanguo.springboot;

import com.sanguo.springboot.domain.NoticeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            logger.info("spring init finish");

            logger.info("begin >>>>>>");
            String message = "eventMessage";
            //publishEvent为同步发送，需要等待事件处理完成，才会继续执行（输出"end<<<<"）
            applicationEventPublisher.publishEvent(new NoticeEvent(message));
            logger.info("end <<<<<<");
        };
    }
}

