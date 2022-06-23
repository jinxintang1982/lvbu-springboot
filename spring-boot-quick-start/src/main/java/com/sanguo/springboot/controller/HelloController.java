package com.sanguo.springboot.controller;

import com.sanguo.springboot.entity.BaseResponse;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController

public class HelloController {
    String host = "http://192.168.1.201:8081";
    String loginUrl = host + "/wms/monitor/session/login?username=admin&pwd=123456";
    String carryUrl = host + "/wms/rest/missions?&sessiontoken=eDQpR09hvAKOtbA4ppYmw7Hpdj4TtTatRe3SzotQoec%3D";
    String statusUrl = host + "/wms/rest/missions/115?&sessiontoken=eDQpR09hvAKOtbA4ppYmw7Hpdj4TtTatRe3SzotQoec%3D";

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello,World!";
    }

    @RequestMapping("/login")
    public BaseResponse login(String stationId) throws Exception {
        RequestForkCarry forkCarry = RequestForkCarry.creator("7","01","02");
        Map<String,RequestForkCarry.Missionrequest> param = new HashMap<>();
        param.put("missionrequest",forkCarry.missionrequest);
        String result = HttpUtil.postRaw(carryUrl,null,param);
        System.out.println(result);
        return new BaseResponse(true,101,stationId);
    }

    @RequestMapping("/login2")
    public BaseResponse login2(String stationId) throws Exception {

        String result = HttpUtil.get(statusUrl,null,null);
        System.out.println(result);
        return new BaseResponse(true,101,stationId);
    }
}
