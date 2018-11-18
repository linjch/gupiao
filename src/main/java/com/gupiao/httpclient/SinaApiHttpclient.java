package com.gupiao.httpclient;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestParam;

public interface SinaApiHttpclient {

    @RequestLine("GET /list={code}")
    public String getGupiaoDetail(@Param("code") String code);
}
