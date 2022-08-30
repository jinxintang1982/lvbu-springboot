package com.sanguo.springboot;

import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.pool.PoolStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Schedules {
    @Autowired
    PoolingHttpClientConnectionManager httpClientConnectionManager;

    @Scheduled(fixedDelay = 1000, initialDelay = 3000)
    public void httpPoolStats() {

        // 获取每个路由的状态
        Set<HttpRoute> routes = httpClientConnectionManager.getRoutes();
        
        routes.forEach(e -> {
            PoolStats stats = httpClientConnectionManager.getStats(e);
            System.out.println("Per route:" + routes.toString() + stats.toString());
        });
        // 获取所有路由的连接池状态
        PoolStats totalStats = httpClientConnectionManager.getTotalStats();
        System.out.println("Total status:" + totalStats.toString());
    }
}
