package com.practice.springwebquick.service.impl;

import com.practice.springwebquick.dao.EmpDao;
import com.practice.springwebquick.pojo.Emp;
import com.practice.springwebquick.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component // 将当前类交给IOC容器管理 成为IOC容器里的bean
public class EmpServiceB implements EmpService {
    @Autowired // 运行时IOC提供该类型的bean对象 赋值给该变量 - 依赖注入
    private EmpDao empDao;
    @Override
    public List<Emp> listEmp() {
        // 调用Dao层的方法
        System.out.println("这是EmpServiceB的listEmp方法");
        return empDao.listEmp();
    }
}
