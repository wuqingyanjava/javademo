package com.example.servicedemo.controller;

import com.example.cxfdemo.service.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/6/4 15:52
 * Modify Log
 **/
@RestController
public class DemoController {


    @PostMapping("/javademo/service/testOne")
    public Model testOne() {

        return Model.newSuccess("访问成功");
    }
}
