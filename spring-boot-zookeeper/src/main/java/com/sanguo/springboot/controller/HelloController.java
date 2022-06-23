package com.sanguo.springboot.controller;

import com.sanguo.springboot.utils.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    ZkClient zkClient;

    @RequestMapping("/helloZk")
    public String sayHello() {
        try {
            zkClient.createExampleNode();
            return "success";
        } catch (Exception e) {
            return e.toString();
        }
    }
}
