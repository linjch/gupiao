package com.gupiao.httpclient;

import feign.Feign;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class SinaApiHttpclientConfig {

    @Value("${sina.gupiao.url}")
    private String sinaGupiaoUrl;

    @Bean
    public SinaApiHttpclient getSinaApiHttpclient(){
        return Feign.builder().target(SinaApiHttpclient.class, sinaGupiaoUrl);
    }
}
