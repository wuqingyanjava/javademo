package com.example.cxfdemo.serviceimpl;

import com.example.cxfdemo.service.IHello;
import com.example.cxfdemo.service.Model;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.jws.WebService;


/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/5/17 10:22
 * Modify Log
 **/

@Component
@WebService(serviceName = "helloService" ,  //【对外发布的服务名 】：需要见名知意
        targetNamespace = "http://service.cxfdemo.example.com" , //【名称空间】：要跟接口的保持一致
        endpointInterface = "com.example.cxfdemo.service.IHello") //【服务接口全路径】
public class HelloImpl implements IHello {

    @Override
    public Model sayHello(String userName) {
        System.out.println("hello!" + userName);
        return Model.newSuccess("hello!" + userName);
    }

    @Override
    public String sayGoobye(String userName) {
        return "Goobye!" + userName;
    }

    @Override
    public String sayJson(String str) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name" , str);
        return jsonObj.toString();
    }
}
