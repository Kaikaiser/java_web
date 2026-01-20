package com.practice.springbootmybatisexampleproject.controller;

import com.practice.springbootmybatisexampleproject.pojo.Emp;
import com.practice.springbootmybatisexampleproject.pojo.Result;
import com.practice.springbootmybatisexampleproject.service.EmpService;
import com.practice.springbootmybatisexampleproject.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class loginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result<String> login(@RequestBody Emp emp){
        log.info("登录请求参数：{}",emp);
        Emp loginEmp = empService.login(emp);

        if(loginEmp != null){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id", loginEmp.getId());
            claims.put("name", loginEmp.getName());
            claims.put("username", loginEmp.getUsername());
            String token = JwtUtils.generateJwt(claims);
            return Result.success(token);
        }
        return Result.error("用户名或密码错误");

    }
}
