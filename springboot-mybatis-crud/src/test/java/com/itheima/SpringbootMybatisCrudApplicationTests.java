package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void test01(){
        // delete 返回的为删除的条目
        System.out.println(empMapper.delete(14));
    }

//    查询信息
    @Test
    public void test02(){
//        System.out.println(empMapper.list("张", (short)1, LocalDate.of(2010,10,1),
//                LocalDate.of(2020,10,1)));

        System.out.println(empMapper.list(null, (short)1,
                null,null));
    }

    @Test
    public void test03(){
//        System.out.println(empMapper.list("张", (short)1, LocalDate.of(2010,10,1),
//                LocalDate.of(2020,10,1)));
        Emp emp = new Emp();
        emp.setId(13);
        emp.setUsername("13272676815");
        emp.setName("汤姆66666");
//        emp.setGender((short)2);
//        emp.setDeptId(1);
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update1(emp);
    }

    @Test
    public void test04(){
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        empMapper.deleteByIds(ids);
    }
}
