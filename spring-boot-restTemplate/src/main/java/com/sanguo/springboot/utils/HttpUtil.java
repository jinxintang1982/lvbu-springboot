package com.sanguo.springboot.utils;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * RestTemplate 工具类
 *
 * @author: linjinp
 * @create: 2019-06-05 14:06
 **/
public class HttpUtil {

    private static class SingletonRestTemplate {
        private static final RestTemplate INSTANCE = new RestTemplate(httpRequestFactory());
    }

    private HttpUtil() {
    }

    public static RestTemplate getInstance() {
        return SingletonRestTemplate.INSTANCE;
    }

    /**
     * post 请求
     *
     * @param url   请求路径
     * @param data  body数据
     * @param token JWT所需的Token，不需要的可去掉
     * @return
     */
    public static String post(String url, String data, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Encoding", "UTF-8");
        headers.add("Content-Type", "application/json; charset=UTF-8");
        if (token != null) {
            headers.add("Authorization", token);
        }
        HttpEntity<String> requestEntity = new HttpEntity<>(data, headers);
        return HttpUtil.getInstance().postForObject(url, requestEntity, String.class);
    }

    /**
     * post 请求
     *
     * @param url  请求路径
     * @param data body数据
     * @return
     */
    public static String post(String url, String data) {
        return post(url, data, null);
    }

    /**
     * get 请求
     *
     * @param url   请求路径
     * @param token JWT所需的Token，不需要的可去掉
     * @return
     */
    public static String get(String url, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Encoding", "UTF-8");
        headers.add("Content-Type", "application/json; charset=UTF-8");
        if (token != null) {
            headers.add("Authorization", token);
        }
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = HttpUtil.getInstance().exchange(url, HttpMethod.GET, requestEntity, String.class);
        String responseBody = response.getBody();
        return responseBody;
    }

    /**
     * 发送文件请求
     *
     * @param url
     * @param token
     * @return
     */
    public static String file(String url, MultipartFile file, String token) {
        // 生成临时文件
        String tempFilePath = System.getProperty("java.io.tmpdir") + file.getOriginalFilename();
        File tmpFile = new File(tempFilePath);
        // 结果，抛异常就是 null
        String result = null;
        try {
            // 保存为文件
            file.transferTo(tmpFile);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());
            headers.setContentType(MediaType.parseMediaType("multipart/form-data;charset=UTF-8"));
            if (token != null) {
                headers.add("Authorization", token);
            }
            MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
            // 把临时文件变成 FileSystemResource
            FileSystemResource resource = new FileSystemResource(tempFilePath);
            param.add("file", resource);
            HttpEntity<MultiValueMap<String, Object>> formEntity = new HttpEntity<>(param, headers);
            result = HttpUtil.getInstance().postForObject(url, formEntity, String.class);
            //删除临时文件文件
            tmpFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static ClientHttpRequestFactory httpRequestFactory() {

        HttpClientBuilder httpClientBuilder =  HttpClientBuilder.create();

        PoolingHttpClientConnectionManager httpClientConnectionManager = new PoolingHttpClientConnectionManager();
        //总连接数
        httpClientConnectionManager.setMaxTotal(10);
        //单录音并发数
        httpClientConnectionManager.setDefaultMaxPerRoute(5);
        httpClientBuilder.setConnectionManager(httpClientConnectionManager);
        HttpClient httpClient = httpClientBuilder.build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        factory.setHttpClient(httpClient);
        //设置超时时长
        factory.setConnectionRequestTimeout(10 * 1000);
        factory.setReadTimeout(10 * 1000);
        factory.setConnectTimeout(10 * 1000);

        return factory;
    }

    private static ClientHttpRequestFactory httpRequestFactory2() {
        HttpClientBuilder httpClientBuilder =  HttpClientBuilder.create();
        httpClientBuilder.setMaxConnTotal(10);
        httpClientBuilder.setMaxConnPerRoute(5);
        HttpClient httpClient = httpClientBuilder.build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(httpClient);

        //设置超时时长
        factory.setConnectionRequestTimeout(10 * 1000);
        factory.setReadTimeout(10 * 1000);
        factory.setConnectTimeout(10 * 1000);

        return factory;
    }
}