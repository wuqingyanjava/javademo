package com.example.jarsperreport.controller;

import com.example.cxfdemo.service.Model;
import com.example.jarsperreport.service.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/6/4 15:52
 * Modify Log
 **/
@RestController
@Api(value="示例controller")
@RequestMapping("/test")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @ApiOperation("测试报表打印接口")
    @GetMapping("/jarsperreport/testprint")
    public void testprint() {
        Map<String,Object> map = new HashMap<>();
        map.put("name","Jaychou");
        map.put("age",38);
        reportService.response("/TestReport.jrxml",map,new ArrayList<>());
    }
}
