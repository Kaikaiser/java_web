package com.practice.springbootmybatisexampleproject.mapper;


import com.practice.springbootmybatisexampleproject.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    /**
     * 分页查询列表数据
     * @param page
     * @param pageSize
     * @return
     */
    @Select("select * from emp limit #{page}, #{pageSize}")
    public List<Emp> page(Integer page, Integer pageSize);

    /**
     * 查总记录数
     * @return
     */
    @Select("select count(*) from emp")
    public Long count();

    /**
     * 查询所有数据
     * @return
     */
    @Select("select * from emp")
    public List<Emp> list();

    //@Select("select * from emp where ")
    public List<Emp> pageby(String name, Short gender,LocalDate begin, LocalDate end, Integer page, Integer pageSize);


    // xml文件
    public void delete(List<Integer> ids);

}
