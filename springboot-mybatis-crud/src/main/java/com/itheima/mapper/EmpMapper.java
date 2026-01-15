package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    //删除数据
    @Delete("delete from emp where id = #{id}")
    public int delete(Integer id);


//    @Select("select * from emp where name like concat('%',#{name},'%') and gender = #{gender} " +
//            "and entrydate between #{begin} and #{end} order by update_time desc limit 0,10")
    public List<Emp> list(String name, Short gender, LocalDate begin,LocalDate end);


//    @Update("update emp set username = #{username}, name = #{name}, gender=#{gender}, dept_id=#{deptId}, " +
//            "update_time = #{updateTime} where id =#{id}")
    public void update1(Emp emp);


    public void deleteByIds(List<Integer> ids);



}
