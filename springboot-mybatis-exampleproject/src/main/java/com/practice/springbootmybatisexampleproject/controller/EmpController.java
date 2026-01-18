package com.practice.springbootmybatisexampleproject.controller;


import com.practice.springbootmybatisexampleproject.pojo.Emp;
import com.practice.springbootmybatisexampleproject.pojo.PageBean;
import com.practice.springbootmybatisexampleproject.pojo.Result;
import com.practice.springbootmybatisexampleproject.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController

//@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    private WebMvcAutoConfiguration.EnableWebMvcConfiguration enableWebMvcConfiguration;

    //    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping("/emps")
    public Result page(//String name, Short gender, LocalDate begin, LocalDate end,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("分页查询所有人的数据：");
        PageBean pageBean = empService.get(page, pageSize);
        return Result.success(pageBean);
    }
    @GetMapping("/by")
    public Result by(String name, Short gender,
                     @DateTimeFormat (pattern = "yyyy-MM-dd") LocalDate begin,
                     @DateTimeFormat (pattern = "yyyy-MM-dd") LocalDate end,
                     @RequestParam(defaultValue = "1") Integer page,
                     @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("按照条件进行分页查询：");
        PageBean pageBean = empService.getby(name, gender, begin, end, page, pageSize);
        return Result.success(pageBean);
    }

    @DeleteMapping("emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("按照序号进行删除：");
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping("emps")
    public Result add(@RequestBody Emp emp){
        log.info("添加新的员工,emp:{}", emp);
        empService.add(emp);
        return Result.success();
    }

}