package com.practice.springbootmybatisexampleproject.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;


//@WebFilter(urlPatterns = "/*")
public class aaaFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("aaaFilter doFilter执行拦截");
        // 放行
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("aaaFilter doFilter放行后的操作");
    }
}
