package com.sanguo.springboot.utils;

public class HttpClientConfig {
    private static final long serialVersionUID = -4608251658338406043L;
    /**
     * 最大连接数
     */
    private Integer maxTotal;
    /**
     * 路由是对最大连接数的细分
     * 每个路由基础的连接数
     */
    private Integer defaultMaxPerRoute;
    /**
     * 连接超时时间
     */
    private Integer connectTimeout;
    /**
     * 从连接池中获取连接的超时时间
     */
    private Integer connectionRequestTimeout;
    /**
     * 服务器返回数据(response)的时间
     */
    private Integer socketTimeout;

    //定义不活动的时间（以毫秒为单位）,连接回收时间。
    private Integer validateAfterInactivity;


    public Integer getValidateAfterInactivity() {
        return validateAfterInactivity;
    }

    public void setValidateAfterInactivity(Integer validateAfterInactivity) {
        this.validateAfterInactivity = validateAfterInactivity;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public Integer getDefaultMaxPerRoute() {
        return defaultMaxPerRoute;
    }

    public void setDefaultMaxPerRoute(Integer defaultMaxPerRoute) {
        this.defaultMaxPerRoute = defaultMaxPerRoute;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Integer getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    public void setConnectionRequestTimeout(Integer connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    public Integer getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(Integer socketTimeout) {
        this.socketTimeout = socketTimeout;
    }
}
