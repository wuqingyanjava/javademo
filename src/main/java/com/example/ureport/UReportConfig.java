package com.example.ureport;

import com.bstek.ureport.console.UReportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UReportConfig {

    @Bean
    public ServletRegistrationBean buildUReportBean(){
        return new ServletRegistrationBean(new UReportServlet(),"/ureport/*");
    }

}