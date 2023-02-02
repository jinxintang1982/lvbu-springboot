package com.zhangchangzhi.actuator.controller;

import com.zhangchangzhi.actuator.domain.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: zhangchangzhi
 * @create: 2020-07-22 17:23
 **/

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello,World!";
    }

    @RequestMapping("/login")
    public BaseResponse login(String stationId) {
        return new BaseResponse(true,101,stationId);
    }
}