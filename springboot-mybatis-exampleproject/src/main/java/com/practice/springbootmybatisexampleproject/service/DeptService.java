package com.practice.springbootmybatisexampleproject.service;


import com.practice.springbootmybatisexampleproject.mapper.DeptMapper;
import com.practice.springbootmybatisexampleproject.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface DeptService {
    /**
     * 查询全部部门数据
     */
    List<Dept> list();

    /**
     * 删除部门
     * @param id
     */
    void deleteDept(Integer id);

    /**
     * 添加部门
     * @param dept
     */
    void add(Dept dept);
}
