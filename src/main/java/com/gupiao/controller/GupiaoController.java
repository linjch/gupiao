package com.gupiao.controller;

import com.gupiao.entity.GupiaoEntity;
import com.gupiao.service.GupiaoService;
import com.gupiao.web.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/gupiao")
public class GupiaoController {

    @Autowired
    private GupiaoService gupiaoService;

    @RequestMapping(value = "/detail/{code}", method = RequestMethod.GET)
    public Result getGupiaoDetail(@PathVariable("code") String code) throws ParseException {
        GupiaoEntity gupiaoDetail = gupiaoService.getGupiaoDetail(code);
        return new Result(Result.SUCCESS, "数据返回成功", gupiaoDetail);
    }
}
