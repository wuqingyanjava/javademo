package com.example.servicedemo.controller;

import com.example.cxfdemo.service.Model;
import com.example.servicedemo.service.TestReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/6/4 15:52
 * Modify Log
 **/
@RestController
@Api(value = "示例controller")
@RequestMapping("/test")
public class DemoController {

    @Autowired
    private TestReportService reportService;

    @ApiOperation("测试post接口")
    @PostMapping("/javademo/service/testPost")
    public Model testPost(@RequestParam(value = "userName") String userName) {

        return Model.newSuccess("post你好" + userName);
    }

    @ApiOperation("测试get接口")
    @GetMapping("/javademo/service/testGet")
    public Model testGet(@RequestParam(value = "userName") String userName) {

        return Model.newSuccess("get你好" + userName);
    }

    @ApiOperation("测试get接口")
    @GetMapping("/javademo/service/testGetData")
    public Model testGetData() {
        reportService.print();
        return Model.newSuccess("get你好");
    }
}
