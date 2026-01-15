package com.practice.springbootmybatisexampleproject.mapper;


import com.practice.springbootmybatisexampleproject.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门数据
     * @return
     */
    @Select("select * from dept")
    public List<Dept> getAll();

    @Delete("delete from dept where id = #{id} ")
    public void deleteById(int id);

    @Insert("insert into dept(id, name, create_time, update_time) value #{id},#{name},#{createTime},#{updateTime}")
    public void add(Dept dept);
}
