package com.sanguo.springboot.subscribe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqttInboundMessageHandler implements MessageHandler {

    public void handleMessage(Message<?> message) throws MessagingException {
        log.info("mqtt reply: {}", message.getPayload());
    }

}
