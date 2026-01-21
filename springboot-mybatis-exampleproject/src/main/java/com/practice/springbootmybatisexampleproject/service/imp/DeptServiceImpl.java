package com.practice.springbootmybatisexampleproject.service.imp;

import com.practice.springbootmybatisexampleproject.mapper.DeptMapper;
import com.practice.springbootmybatisexampleproject.mapper.EmpMapper;
import com.practice.springbootmybatisexampleproject.pojo.Dept;
import com.practice.springbootmybatisexampleproject.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.getAll();
    }

    @Transactional(rollbackFor = Exception.class) // rollbackFor = Exception.class表示事务回滚所有异常，不加默认只回滚RuntimeException
    @Override
    public void deleteDept(Integer id) {

        deptMapper.deleteById(id);
        Integer a = id/0;
        empMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        dept.setCreateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
