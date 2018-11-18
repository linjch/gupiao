package com.gupiao.service;

import com.google.gson.Gson;
import com.gupiao.entity.GupiaoEntity;
import com.gupiao.entity.SohuGupiaoReturn;
import com.gupiao.httpclient.SinaApiHttpclient;
import com.gupiao.httpclient.SohuApiHttpclient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GupiaoService {

    @Autowired
    private SinaApiHttpclient sinaApiHttpclient;

    @Autowired
    private SohuApiHttpclient sohuApiHttpclient;

    public GupiaoEntity getGupiaoDetail(String code) throws ParseException {
        String gupiaoDetail = sinaApiHttpclient.getGupiaoDetail(code);
        return new GupiaoEntity(code, gupiaoDetail);
    }

    public List<GupiaoEntity> getGupiaoInfoBySohuApi(String code, String startDate, String endDate){
        SohuGupiaoReturn sohuGupiaoReturn = sohuApiHttpclient.getGupiaoDetail(code, startDate, endDate);
        List<GupiaoEntity> results = new ArrayList<GupiaoEntity>();
        if(null == sohuGupiaoReturn)  return results;
        List<String[]> gupiaoList = sohuGupiaoReturn.getHq();
        if(null == gupiaoList) return results;
        int size = gupiaoList.size();
        if(size < 1) return results;
        for(int i = 0; i < size; i++){
            String[] gupiao = gupiaoList.get(i);
            results.add(new GupiaoEntity(sohuGupiaoReturn.getCode(), gupiao));
        }
        return results;
    }
}
