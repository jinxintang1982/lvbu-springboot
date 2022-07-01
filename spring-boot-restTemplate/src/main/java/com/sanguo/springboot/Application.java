package com.sanguo.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@EnableScheduling
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("---------springboot start up------");
    }
}

public class HttpUtils {
    @Autowired(required = false)
    private MeterRegistry meterRegistry;
    private static PoolingHttpClientConnectionManager poolingHttpClientConnectionManager;
    static PoolStats poolStats = new PoolStats(); // 内部类，用于存储Pool的数据

    public static class PoolStats {
        public int getAvailable() {
            return HttpUtils.getConnectionPoolTotalAvailable();
        }

        public int getLeased() {
            return HttpUtils.getConnectionPoolTotalLeased();
        }

        public int getPending() {
            return HttpUtils.getConnectionPoolTotalPending();
        }

        public int getMax() {
            return HttpUtils.getConnectionPoolTotalMax();
        }
    } // 从poolingHttpClientConnectionManager 获取

    public static String getConnectionPoolStats() {
        if (poolingHttpClientConnectionManager != null && poolingHttpClientConnectionManager instanceof PoolingHttpClientConnectionManager) {
            return poolingHttpClientConnectionManager.getTotalStats().toString();
        }
        return '';
    }

    public static int getConnectionPoolTotalLeased() {
        if (poolingHttpClientConnectionManager != null && poolingHttpClientConnectionManager instanceof PoolingHttpClientConnectionManager) {
            return poolingHttpClientConnectionManager.getTotalStats().getLeased();
        }
        return 0;
    }

    public static int getConnectionPoolTotalPending() {
        if (poolingHttpClientConnectionManager != null && poolingHttpClientConnectionManager instanceof PoolingHttpClientConnectionManager) {
            return poolingHttpClientConnectionManager.getTotalStats().getPending();
        }
        return 0;
    }

    private void bindMetricsRegistryToConnectionPoolStats(PoolStats poolStats, MeterRegistry meterRegistry) {
        Gauge.builder('httpclient_connections_pool_available', poolStats, PoolStats::getAvailable).description('Gets the number idle persistent connections.').tag('httpclient_connections_pool', 'available').register(meterRegistry);
        Gauge.builder('httpclient_connections_pool_leased', poolStats, PoolStats::getLeased).description('Gets the number of persistent connections tracked by the connection manager currently being used to executerequests.').tag('httpclient_connections_pool', 'leased').register(meterRegistry);
        Gauge.builder('httpclient_connections_pool_pending', poolStats, PoolStats::getPending).description('Gets the number of connection requests being blocked awaiting a free connection. This can happen only if thereare more worker threads contending for fewer connections.').tag('httpclient_connections_pool', 'pending').register(meterRegistry);
    }

    private CloseableHttpClient getSslHttpClient() {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(); // https://stackoverflow.com/questions/30689995/what-does-setdefaultmaxperroute-and-setmaxtotal-mean-in-httpclient
        poolingHttpClientConnectionManager.setMaxTotal(HttpUtil.POOL_MAX_TOTAL);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(HttpUtil.POOL_DEFAULT_MAX_PERROUTE);
        poolingHttpClientConnectionManager.setValidateAfterInactivity(HttpUtil.POOL_CONNECTION_REQUEST_TIMEOUT); // 自定义方法用来绑定监控, 注意一点 poolStats一定要是static，否则会随着gc，弱引用，导致获取的数据变为 Nan
        this.bindMetricsRegistryToConnectionPoolStats(poolStats, this.meterRegistry);
        httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager);
        return httpClientBuilder.build();
    }
}