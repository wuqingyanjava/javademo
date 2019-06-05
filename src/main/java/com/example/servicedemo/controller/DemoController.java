package com.example.servicedemo.controller;

import com.example.cxfdemo.service.Model;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/6/4 15:52
 * Modify Log
 **/
@RestController
public class DemoController {

    @ApiOperation("测试第一个接口")
    @PostMapping("/javademo/service/testOne")
    public Model testOne(@RequestParam(value = "userName") String userName) {

        return Model.newSuccess(userName);
    }
}
