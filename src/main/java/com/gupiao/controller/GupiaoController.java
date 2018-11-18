package com.gupiao.controller;

import com.gupiao.entity.GupiaoEntity;
import com.gupiao.service.GupiaoService;
import com.gupiao.web.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/gupiao")
public class GupiaoController {

    @Autowired
    private GupiaoService gupiaoService;

    /**
     * code : sh601318,sz000538
     * */
    @RequestMapping(value = "/detail/{code}", method = RequestMethod.GET)
    public Result getGupiaoDetail(@PathVariable("code") String code) throws ParseException {
        GupiaoEntity gupiaoDetail = gupiaoService.getGupiaoDetail(code);
        return new Result(Result.SUCCESS, "数据返回成功", gupiaoDetail);
    }

    /**
     * code : cn_601318
     * startDate : 20181101
     * endDate : 20181116
     * */
    @RequestMapping(value = "/list/{code}/{startDate}/{endDate}", method = RequestMethod.GET)
    public Result getGupiaoList(@PathVariable("code") String code, @PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate){
        List<GupiaoEntity> gupiaoList = gupiaoService.getGupiaoInfoBySohuApi(code,startDate, endDate);
        if(null == gupiaoList || gupiaoList.size() < 1){
            return new Result(Result.FAIL, "数据返回失败", gupiaoList);
        }
        return new Result(Result.SUCCESS, "数据返回成功", gupiaoList);
    }
}
