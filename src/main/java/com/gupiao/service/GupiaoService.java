package com.gupiao.service;

import com.gupiao.entity.GupiaoEntity;
import com.gupiao.httpclient.GupiaoApiHttpclient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class GupiaoService {

    @Autowired
    private GupiaoApiHttpclient sinaApiHttpclient;

    public GupiaoEntity getGupiaoDetail(String code) throws ParseException {
        String gupiaoDetail = sinaApiHttpclient.getGupiaoDetail(code);
        return new GupiaoEntity(code, gupiaoDetail);
    }
}
