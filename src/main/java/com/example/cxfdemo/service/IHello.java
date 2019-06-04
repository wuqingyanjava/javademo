package com.example.cxfdemo.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/5/17 10:19
 * Modify Log
 **/
@WebService(targetNamespace = "http://service.cxfdemo.example.com")
public interface IHello {

    @WebMethod
    public @WebResult
    Model sayHello(@WebParam(name = "userName") String userName);

    @WebMethod
    public @WebResult String sayGoobye(@WebParam(name = "userName") String userName);

    @WebMethod
    public @WebResult String sayJson(@WebParam(name = "userName")String userName);


}
