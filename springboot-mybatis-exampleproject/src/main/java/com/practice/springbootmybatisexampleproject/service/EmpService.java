package com.practice.springbootmybatisexampleproject.service;

import com.practice.springbootmybatisexampleproject.pojo.Emp;
import com.practice.springbootmybatisexampleproject.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    //public PageBean get(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize);
    public PageBean get(Integer page, Integer pageSize);



    public PageBean getby(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize);

    public void delete(List<Integer> ids);

    void add(Emp emp);

    Emp login(Emp emp);
}
