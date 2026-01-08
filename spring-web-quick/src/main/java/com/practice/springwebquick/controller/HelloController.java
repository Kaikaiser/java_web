package com.practice.springwebquick.controller;

import com.practice.springwebquick.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.pattern.PathPatternParser;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * 测试请求参数接受
 */
@RestController
public class HelloController {
    private final PathPatternParser mvcPatternParser;

    public HelloController(PathPatternParser mvcPatternParser) {
        this.mvcPatternParser = mvcPatternParser;
    }

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


    // 对象方式
    @RequestMapping("/simpleObject")
    public String simpleObject(User user){
        System.out.println(user);
        return "OK";
    }

    // 数组传递
    @RequestMapping("/arrayParse")
    public String arrayParse(String[] s){
        System.out.println(Arrays.toString(s));
        return "OK";
    }

    // 列表传递
    @RequestMapping("/listParse")
    public String arrayParse(@RequestParam List<String> list){
        System.out.println(list);
        return "OK";
    }

    // 日期传递
    @RequestMapping("/dateParam")
    public String arrayParse(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);
        return "OK";
    }

    // json格式传递
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "Ok";
    }

    // 路径参数
    @RequestMapping("/pathParam/{id}/{home}")
    public String jsonParam(@PathVariable Integer id , @PathVariable String home){
        System.out.println(id);
        System.out.println(home);
        return "Ok";
    }
}
