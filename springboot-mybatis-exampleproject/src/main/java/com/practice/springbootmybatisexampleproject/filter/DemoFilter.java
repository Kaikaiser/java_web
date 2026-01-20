package com.practice.springbootmybatisexampleproject.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import javax.annotation.processing.Filer;
import java.io.IOException;

@WebFilter(urlPatterns = "/login")
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("DemoFilter init执行");
    }


    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("DemoFilter destroy执行");
    }

    /**
     *每次执行操作doFilter都会拦截
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("DemoFilter doFilter执行拦截");
        // 放行
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("DemoFilter doFilter放行后的操作");
    }
}
