package com.sanguo.springboot.controller;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.StandardHttpRequestRetryHandler;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * httpclient封装工具类
 */
public class HttpUtil {

    private static final Map<String, ?> EMPTY_PARAMS = new HashMap<>();

    private static final RequestConfig REQUEST_CONFIG = RequestConfig.custom()
            /**数据传输过程中数据包之间间隔的最大时间*/
            .setSocketTimeout(5000)
            /**连接建立时间，三次握手完成时间*/
            .setConnectTimeout(5000)
            /**httpclient使用连接池来管理连接，这个时间就是从连接池获取连接的超时时间*/
            .setConnectionRequestTimeout(5000)
            .build();

    private static URI toURI(String url) {
        try {
            return new URI(url);
        } catch (URISyntaxException e) {
            throw new RuntimeException(String.format("url format error: interface=%s", url));
        }
    }

    public static String get(String url, Map<String, String> headers, Map<String, ?> params) throws Exception {
        return request(toURI(url), headers, params, Method.GET);
    }

    public static String postForm(String url, Map<String, String> headers, Map<String, ?> params) throws Exception {
        System.out.println("==============postForm===========");
        return request(toURI(url), headers, params, Method.POST_FORM);
    }

    public static String postRaw(String url, Map<String, String> headers, Map<String, ?> params) throws Exception {
        return request(toURI(url), headers, params, Method.POST_RAW);
    }

    public static String putRaw(String url, Map<String, String> headers, Map<String, ?> params) throws Exception {
        return request(toURI(url), headers, params, Method.PUT_RAW);
    }

    public static String delete(String url, Map<String, String> headers, Map<String, ?> params) throws Exception {
        return request(toURI(url), headers, params, Method.DELETE);
    }

    public static String request(URI uri, Map<String, String> headers, Map<String, ?> params, Method method) throws Exception {
        CloseableHttpClient httpClient = HttpClients.custom()
                /**设置重试次数, 3次*/
                .setRetryHandler(new StandardHttpRequestRetryHandler(3, true))
                /**设置最长时间的连接, 5000 ms*/
                .setConnectionTimeToLive(10000, TimeUnit.MILLISECONDS)
                .build();
        CloseableHttpResponse response = null;
        try {
            HttpUriRequest request;
            switch (method) {
                case GET:
                    request = createHttpGet(uri, REQUEST_CONFIG, headers, params);
                    break;
                case POST_FORM:
                    request = createHttpPostForm(uri, REQUEST_CONFIG, headers, params);
                    break;
                case POST_RAW:
                    request = createHttpPostRaw(uri, REQUEST_CONFIG, headers, params);
                    break;
                case PUT_RAW:
                    request = createHttpPutRaw(uri, REQUEST_CONFIG, headers, params);
                    break;
                case DELETE:
                    request = createHttpDelete(uri, REQUEST_CONFIG, headers, params);
                    break;
                default:
                    throw new RuntimeException("unsupported Method " + method);
            }
            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");

            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new Exception(responseString);
            }

            return responseString;
        } catch (Exception e) {
            throw e;
        } finally {
            // 关闭连接,释放资源
            close(response);
            close(httpClient);
        }
    }

    /**
     * 创建get请求
     *
     * @param uri
     * @param requestConfig
     * @param params
     * @return
     */
    private static HttpGet createHttpGet(URI uri, RequestConfig requestConfig, Map<String, String> headers, Map<String, ?> params) {
        HttpGet httpGet = new HttpGet(getUriWithQueryStringParams(uri, params));
        httpGet.setConfig(requestConfig);

        if (null != headers) {
            headers.forEach(httpGet::setHeader);
        }
        return httpGet;
    }

    /**
     * 创建post form请求, map以key-value方式发送
     *
     * @param uri
     * @param requestConfig
     * @param params
     * @return
     * @throws UnsupportedEncodingException
     */
    private static HttpPost createHttpPostForm(URI uri, RequestConfig requestConfig, Map<String, String> headers, Map<String, ?> params) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setConfig(requestConfig);
        HttpEntity httpParam = new UrlEncodedFormEntity(getNameValuePairList(params), "UTF-8");
        httpPost.setEntity(httpParam);

        if (null != headers) {
            headers.forEach(httpPost::setHeader);
        }
        return httpPost;
    }

    /**
     * 创建post raw请求，map以json字符串方式发送
     *
     * @param uri
     * @param requestConfig
     * @param params
     * @return
     * @throws UnsupportedEncodingException
     */
    private static HttpPost createHttpPostRaw(URI uri, RequestConfig requestConfig, Map<String, String> headers, Map<String, ?> params) {
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setConfig(requestConfig);
        httpPost.setHeader("Content-type", "application/json");
        StringEntity httpParam = new StringEntity(JSON.toJSONString(null != params ? params : EMPTY_PARAMS), "UTF-8");
        httpPost.setEntity(httpParam);

        if (null != headers) {
            headers.forEach(httpPost::setHeader);
        }
        return httpPost;
    }

    private static HttpPut createHttpPutRaw(URI uri, RequestConfig requestConfig, Map<String, String> headers, Map<String, ?> params) {
        HttpPut httpPut = new HttpPut(uri);
        httpPut.setConfig(requestConfig);
        httpPut.setHeader("Content-type", "application/json");
        StringEntity httpParam = new StringEntity(JSON.toJSONString(null != params ? params : EMPTY_PARAMS), "UTF-8");
        httpPut.setEntity(httpParam);

        if (null != headers) {
            headers.forEach(httpPut::setHeader);
        }
        return httpPut;
    }

    private static HttpDelete createHttpDelete(URI uri, RequestConfig requestConfig, Map<String, String> headers, Map<String, ?> params) {
        HttpDelete httpPut = new HttpDelete(getUriWithQueryStringParams(uri, params));
        httpPut.setConfig(requestConfig);

        if (null != headers) {
            headers.forEach(httpPut::setHeader);
        }
        return httpPut;
    }

    /**
     * 获取带url参数的URI
     *
     * @param uri
     * @param params
     * @return
     */
    private static URI getUriWithQueryStringParams(URI uri, Map<String, ?> params) {
        if (null != params && !params.isEmpty()) {
            URIBuilder builder = new URIBuilder(uri).setParameters(getNameValuePairList(params));
            try {
                uri = builder.build();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        return uri;
    }

    private static List<NameValuePair> getNameValuePairList(Map<String, ?> param) {
        if (param == null || param.isEmpty()) {
            return Collections.emptyList();
        }

        List<NameValuePair> list = new ArrayList<>();
        param.forEach((key, value) -> {
            BasicNameValuePair pair = new BasicNameValuePair(key, String.valueOf(value));
            list.add(pair);
        });
        return list;
    }

    private static void close(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public enum Method {
        /**
         * get
         */
        GET,

        /**
         * post： raw
         */
        POST_RAW,

        /**
         * post： form
         */
        POST_FORM,

        /**
         * put： raw
         */
        PUT_RAW,

        /**
         * delete
         */
        DELETE
    }
}
