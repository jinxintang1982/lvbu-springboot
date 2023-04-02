package com.sanguo.springboot.controller;

import com.sanguo.springboot.publish.MqttTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mqtt")
public class SendController {

    @Autowired
    MqttTemplate mqttTemplate;

    @RequestMapping(value = "send", method = RequestMethod.POST)
    public String sendMqtt() {
        mqttTemplate.sendToTopic("first blood","zcz/send");
        return "success";
    }
}
