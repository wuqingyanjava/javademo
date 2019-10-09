package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ImportResource("classpath:context.xml")
@EnableScheduling  //开启spring-schedule定时任务
@ServletComponentScan //项目启动自动扫描Servlet组件。Filter属于Servlet组件
public class CxfdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CxfdemoApplication.class, args);
    }

}
