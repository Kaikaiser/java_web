package com.practice.springwebquick.service.impl;

import com.practice.springwebquick.dao.EmpDao;
import com.practice.springwebquick.pojo.Emp;
import com.practice.springwebquick.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
//@Service
public class EmpServiceA implements EmpService {
    @Autowired
    private EmpDao empDao;
    @Override
    public List<Emp> listEmp() {
        // 调用Dao层的方法
        System.out.println("这是EmpServiceA的listEmp方法");
        return empDao.listEmp();
    }
}
