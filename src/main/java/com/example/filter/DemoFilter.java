package com.example.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/10/8 14:17
 * Modify Log
 **/
@Slf4j
@WebFilter(urlPatterns = "/test/javademo/service/*")
public class DemoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("进入DemoFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        log.info(request.getRequestURI());
//        Map a = new HashMap(request.getParameterMap());
//        a.put("userName","aaa");
        String userName = request.getParameter("userName");
        log.info(userName);
        HttpSession session =request.getSession();
        //检查是否是登录页面
        String status= (String) session.getAttribute("isLogin");
        if(status==null || !status.equals("true"))
        {
            log.info("未登录！！！！");
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
