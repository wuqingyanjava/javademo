package com.example.cxfdemo;

import com.example.cxfdemo.serviceimpl.HelloImpl;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/5/17 10:29
 * Modify Log
 **/
@Configuration
public class CxfConfig {

    @Autowired
    private HelloImpl hello;
    @Bean
    public ServletRegistrationBean getDispatcherServlet() { //注意这个方法名 网上好多用dispatcherServlet启动会报错
        return new ServletRegistrationBean(new CXFServlet(), "/cxf/*");// 发布服务名称 localhost:8080/cxf
    }
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }
    @Bean
    public Endpoint hello() {
        // 绑定要发布的服务实现类
        EndpointImpl endpoint = new EndpointImpl(springBus(),hello);
        endpoint.publish("/service"); // 接口访问地址
        return endpoint;
    }
//    @Bean
//    public Endpoint goodbye() {
//        // 绑定要发布的服务实现类
//        EndpointImpl endpoint = new EndpointImpl(springBus(),hello);
//        endpoint.publish("/goodbye"); // 接口访问地址
//        return endpoint;
//    }
//    @Bean
//    public Endpoint sayJson() {
//        // 绑定要发布的服务实现类
//        EndpointImpl endpoint = new EndpointImpl(springBus(),hello);
//        endpoint.publish("/sayJson"); // 接口访问地址
//        return endpoint;
//    }
}
