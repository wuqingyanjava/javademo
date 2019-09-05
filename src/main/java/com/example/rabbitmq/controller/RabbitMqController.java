package com.example.rabbitmq.controller;

import com.example.cxfdemo.service.Model;
import com.example.rabbitmq.producer.MsgProducer;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/6/6 13:51
 * Modify Log
 **/
@RestController
public class RabbitMqController {

    @Autowired
    private MsgProducer msgProducer;

    @ApiOperation("测试mq接口")
    @PostMapping("/rabbitmq/sendMsg")
    public Model sendMsg(@RequestParam(value = "用户名") String msg) {
        for (int i = 0; i < 5; i++) {
            msgProducer.sendMsgA(msg + i);
            //msgProducer.sendMsgB(msg+i);
        }
        return Model.newSuccess("发送消息：" + msg);
    }

}
