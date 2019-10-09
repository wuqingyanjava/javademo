package com.example.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/10/9 9:46
 * Modify Log
 **/
@Slf4j
public class DemoInterceptor implements HandlerInterceptor {

    public DemoInterceptor(){}

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("---------------------开始进入请求地址拦截----------------------------");
        String queryString = request.getQueryString();
        String requestURL = request.getRequestURL().toString();
        System.out.println("拦截器1，如入参：" + queryString + "访问地址，" + requestURL);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        log.info("--------------处理请求完成后视图渲染之前的处理操作---------------");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)  {
        log.info("---------------视图渲染之后的操作-------------------------0");
    }

}
