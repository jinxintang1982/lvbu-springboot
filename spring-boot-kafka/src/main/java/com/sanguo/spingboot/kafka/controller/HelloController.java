package com.sanguo.spingboot.kafka.controller;

import com.sanguo.spingboot.kafka.provider.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    Sender sender;

    @RequestMapping("/hello")
    public String sayHello() {
        sender.send();
        return "send already";
    }
}
