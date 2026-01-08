package com.practice.springwebquick.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试请求参数接受
 */
@RestController
public class HelloController {
    // 原始方式
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello world");
        return "hello world12138";
    }

    // servlet方式（旧版）
    @RequestMapping("/simpleParse")
    public String simpleParse(HttpServletRequest request) {
        // 获取请求参数
        String name = request.getParameter("name");
        String ageStr = request.getParameter("ageStr");

        int age = Integer.parseInt(ageStr);
        System.out.println(name + ": " + age);
        return "OK";
    }


    // springboot方式
    @RequestMapping("/simpleParseNew")
    public String simpleParseNew(@RequestParam(name = "name",required = false)String username, Integer age) {
        System.out.println(username + ": " + age);
        return "OK";
    }
}
