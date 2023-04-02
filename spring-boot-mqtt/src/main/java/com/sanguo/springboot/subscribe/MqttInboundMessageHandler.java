package com.sanguo.springboot.subscribe;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;


public class MqttInboundMessageHandler implements MessageHandler {

    public void handleMessage(Message<?> message) throws MessagingException {
        System.out.println("mqtt reply: {}"+ message.getPayload());
    }

}
