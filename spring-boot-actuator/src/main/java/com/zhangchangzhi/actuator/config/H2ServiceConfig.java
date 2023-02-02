package com.zhangchangzhi.actuator.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: zhangchangzhi
 * @create: 2020-07-22 17:44
 **/
@Component
@ConfigurationProperties(prefix = "h2service")
public class H2ServiceConfig {
    private String ip;

    private String port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
