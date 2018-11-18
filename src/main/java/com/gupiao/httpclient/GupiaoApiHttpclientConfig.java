package com.gupiao.httpclient;

import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.Feign;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class GupiaoApiHttpclientConfig {

    @Value("${sina.gupiao.url}")
    private String sinaGupiaoUrl;

    @Bean
    public GupiaoApiHttpclient getSinaApiHttpclient(){
        return Feign.builder().target(GupiaoApiHttpclient.class, sinaGupiaoUrl);
    }
}
