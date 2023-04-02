package com.sanguo.springboot.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "mqtt")
public class MqttProperties {
    private String url;
    private String username;
    private String password;
    private String clientId;
}
