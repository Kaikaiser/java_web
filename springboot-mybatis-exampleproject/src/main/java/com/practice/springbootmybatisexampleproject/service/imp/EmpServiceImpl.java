package com.practice.springbootmybatisexampleproject.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.practice.springbootmybatisexampleproject.mapper.EmpMapper;
import com.practice.springbootmybatisexampleproject.pojo.Emp;
import com.practice.springbootmybatisexampleproject.pojo.PageBean;
import com.practice.springbootmybatisexampleproject.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean get(Integer page, Integer pageSize) {
        PageBean pageBean = new PageBean(empMapper.count(), empMapper.page((page-1)*pageSize, pageSize));
        return pageBean;
    }

    @Override
    public PageBean getby(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        PageBean pageBean = new PageBean(empMapper.count(),
                empMapper.pageby(name,gender,begin, end,(page-1)*pageSize, pageSize));
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);

    }

    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.selectByUsernameAndPassword(emp);
    }


//    @Override
//    public PageBean get(Integer page, Integer pageSize) {
//        PageHelper.startPage(page, pageSize);
//        Page<Emp> p = (Page<Emp>) empMapper.list();
//        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
//        return pageBean;
//    }
}
