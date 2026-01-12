package com.practice.springwebquick.dao.impl;

import com.practice.springwebquick.dao.EmpDao;
import com.practice.springwebquick.pojo.Emp;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Component
@Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = new ArrayList<>();
        int temp = 18;
        for (int i = 0; i < 3; i++) {
            temp++;
            Emp emp = new Emp(temp, "男", "张三");
            empList.add(emp);
        }

        return empList;
    }
}
