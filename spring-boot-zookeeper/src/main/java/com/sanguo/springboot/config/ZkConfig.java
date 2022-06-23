package com.sanguo.springboot.config;

import com.sanguo.springboot.utils.ZkClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "zookeeper")
@Component
public class ZkConfig {
    @Bean(initMethod = "init", destroyMethod = "stop")
    public ZkClient zkClient() {
        ZkClient zkClient = new ZkClient();
        zkClient.setZookeeperServer(server);
        zkClient.setSessionTimeoutMs(sessionTimeoutMs);
        zkClient.setConnectionTimeoutMs(connectionTimeoutMs);
        zkClient.setMaxRetries(maxRetries);
        zkClient.setBaseSleepTimeMs(baseSleepTimeMs);
        return zkClient;
    }

    private String server;
    private int sessionTimeoutMs;
    private int connectionTimeoutMs;
    private int maxRetries;
    private int baseSleepTimeMs;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getSessionTimeoutMs() {
        return sessionTimeoutMs;
    }

    public void setSessionTimeoutMs(int sessionTimeoutMs) {
        this.sessionTimeoutMs = sessionTimeoutMs;
    }

    public int getConnectionTimeoutMs() {
        return connectionTimeoutMs;
    }

    public void setConnectionTimeoutMs(int connectionTimeoutMs) {
        this.connectionTimeoutMs = connectionTimeoutMs;
    }

    public int getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public int getBaseSleepTimeMs() {
        return baseSleepTimeMs;
    }

    public void setBaseSleepTimeMs(int baseSleepTimeMs) {
        this.baseSleepTimeMs = baseSleepTimeMs;
    }


}
