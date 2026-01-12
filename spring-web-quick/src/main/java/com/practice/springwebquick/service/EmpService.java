package com.practice.springwebquick.service;

import com.practice.springwebquick.pojo.Emp;
import org.springframework.stereotype.Component;

import java.util.List;


public interface EmpService {
    public List<Emp> listEmp();
}
