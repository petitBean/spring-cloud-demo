package com.wxz.eurekazuulclient.netflixHystrix;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Wangxingze
 * @date 2019-08-24 01:11
 */

/**
 * 路由到eureka-client服务的熔断器
 */
@Component
public class EurekaClientHystrix implements FallbackProvider {

    /**
     * 指定熔断器作用与哪一个服务
     * @return
     */
    @Override
    public String getRoute() {
        return "eureka-client";
    }

    /**
     * 快速失败的执行逻辑板
     * @param route
     * @param cause
     * @return 必须返回一个 clientresponse
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "ok";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("oh! 我是fallback".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers=new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
