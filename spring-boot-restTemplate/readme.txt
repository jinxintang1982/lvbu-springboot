一、RestTemplate的引用：

RestTemplate内部引用了ClientHttpRequestFactory接口，该接口常用的有4个实现类：
    HttpComponentsClientHttpRequestFactory：底层为HttpClient(apache)
    SimpleClientHttpRequestFactory：底层为HttpURLConnection（JDK1.8）
    OkHttp3ClientHttpRequestFactory：底层为OkHttpClient(android)
    Netty4ClientHttpRequestFactory：


二、HttpComponentsClientHttpRequestFactory包含两个实例：HttpClient和RequestConfig

HttpClient：可以通过httpClientBuilder的create()方法创建，然后通过 build() 进行默认配置；
    注：
    HttpClientConnectionManager类包含了maxTotal,defaultMaxPerRoute的配置；

    在build()方法中，如果没有设置httpClientConnectionManager，则设置HttpClient为默认配置；最大链接数为10，单路由为5；
                    String s = System.getProperty("http.keepAlive", "true");
                    if ("true".equalsIgnoreCase(s)) {
                        s = System.getProperty("http.maxConnections", "5");
                        int max = Integer.parseInt(s);
                        poolingmgr.setDefaultMaxPerRoute(max);
                        poolingmgr.setMaxTotal(2 * max);
                    }

    如果设置了httpClientConnectionManager，则在创建连接时使用HttpClientConnectionManager;
                    createMainExec(HttpRequestExecutor requestExec, HttpClientConnectionManager connManager...

    如果不想使用HttpClientConnectionManager，也可以直接通过httpClientBuilder设置defaultMaxPerRoute和maxTotal；
                    httpClientBuilder.setMaxConnTotal(10);
                    httpClientBuilder.setMaxConnPerRoute(20);

RequestConfig：包含配置ConnectTimeout,RequestTimeout,ReadTimeout

三、RestTemplate装配过程；
方案一：直接使用ClientConnectionManager
新建PoolingHttpClientConnectionManager配置setMaxTotal，setDefaultMaxPerRoute；
    httpClientConnectionManager.setMaxTotal(1);

新建HttpClientBuilder配置PoolingHttpClientConnectionManager；HttpClientBuilder <- PoolingHttpClientConnectionManager
    httpClientBuilder.setConnectionManager(httpClientConnectionManager);

通过HttpClientBuilder创建HttpClient,如果没有设置ConnectionManager，则为在build()中创建如果没有设置ConnectionManager，并设置默认值；
    HttpClient httpClient = httpClientBuilder.build();

新建HttpComponentsClientHttpRequestFactory配置HttpClient:HttpComponentsClientHttpRequestFactory <- HttpClient
    factory.setHttpClient(httpClient);

方案二：间接使用ClientConnectionManager
新建HttpClientBuilder配置链接池熟悉：
    httpClientBuilder.setMaxConnTotal(10);
    httpClientBuilder.setMaxConnPerRoute(20);

通过HttpClientBuilder创建HttpClient,如果没有设置ConnectionManager，则为httpClient设置默认值；
     HttpClient httpClient = httpClientBuilder.build();

新建HttpComponentsClientHttpRequestFactory配置HttpClient:HttpComponentsClientHttpRequestFactory <- HttpClient
     factory.setHttpClient(httpClient);