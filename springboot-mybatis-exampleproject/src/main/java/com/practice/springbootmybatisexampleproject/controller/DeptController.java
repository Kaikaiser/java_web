package com.practice.springbootmybatisexampleproject.controller;


import com.practice.springbootmybatisexampleproject.mapper.DeptMapper;
import com.practice.springbootmybatisexampleproject.pojo.Dept;
import com.practice.springbootmybatisexampleproject.pojo.Result;
import com.practice.springbootmybatisexampleproject.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController

@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result getAllDepts(){
        log.info("查看所有部门的数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result deleteDept(@PathVariable Integer id){
        log.info("删除的部门为：", id);
        deptService.deleteDept(id);
        return Result.success();
    }

    @PostMapping
    public Result addDept(@RequestBody Dept dept){
        deptService.add(dept);
        return Result.success();
    }

    @PutMapping
    public Result updateDept(@RequestBody Dept dept){
        deptService.update(dept);
        return Result.success();
    }
}
