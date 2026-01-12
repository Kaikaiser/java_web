package com.practice.springwebquick.controller;

import com.practice.springwebquick.pojo.Emp;
import com.practice.springwebquick.pojo.Result;
import com.practice.springwebquick.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/getlistEmp", method = RequestMethod.GET)
    public Result getlistEmp() {
        System.out.println("这是一个分层式架构！！");
        List<Emp> emplist = empService.listEmp();
        return Result.success(emplist);
    }
}
