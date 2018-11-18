package com.gupiao.httpclient;

import com.google.gson.JsonElement;
import com.gupiao.entity.SohuGupiaoReturn;
import feign.Param;
import feign.RequestLine;

public interface SohuApiHttpclient {

    @RequestLine("GET /hisHq?code={code}&start={startDate}&end={endDate}&stat=1&order=D&period=d&callback=historySearchHandler&rt=json")
    public SohuGupiaoReturn getGupiaoList(@Param("code") String code, @Param("startDate") String startDate, @Param("endDate") String endDate);
}
