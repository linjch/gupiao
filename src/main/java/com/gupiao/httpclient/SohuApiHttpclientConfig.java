package com.gupiao.httpclient;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class SohuApiHttpclientConfig {

    @Value("${sohu.gupiao.url}")
    private String sohuGupiaoUrl;

    @Bean
    public SohuApiHttpclient getSohuApiHttpclient(){
        return Feign.builder().encoder(new JacksonEncoder()).target(SohuApiHttpclient.class, sohuGupiaoUrl);
    }
}
