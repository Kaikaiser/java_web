package com.practice.springbootmybatisexampleproject.service.imp;

import com.practice.springbootmybatisexampleproject.mapper.DeptMapper;
import com.practice.springbootmybatisexampleproject.pojo.Dept;
import com.practice.springbootmybatisexampleproject.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;


    @Override
    public List<Dept> list() {
        return deptMapper.getAll();
    }

    @Override
    public void deleteDept(Integer id) {
        deptMapper.deleteById(id);
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
