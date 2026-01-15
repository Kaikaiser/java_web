package com.practice.springmybatisquick.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.practice.springmybatisquick.pojo.User;

import java.util.List;

@Mapper // 在运行时会自动生成接口的实现类对象（代理对象），并且把该对象交给IOC管理
public interface UserMapper {
    @Select("select * from user")
    public List<User> list();

}
