package com.sd.tliaswebmanagement.mapper;

import com.sd.tliaswebmanagement.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;



@Mapper
public interface DeptMapper {
    // 查询所有部门信息
    //方式 1：手动 映射
//    @Results({
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime"),
//    })
    //方式 2：起别名
//    @Select("SELECT id, name,create_time createTime,update_time updateTime FROM dept order by update_time desc")
    @Select("SELECT id, name,create_time ,update_time FROM dept order by update_time desc")
    List<Dept> findAll();
    @Delete("delete from dept where id = #{id}")
    void deleteById(int id);
    @Insert("insert into dept (name,create_time,update_time) values (#{name},#{createTime},#{updateTime})")
    void add(Dept dept);
    @Select("select id, name,create_time ,update_time from dept where id = #{id}")
    Dept getById(Integer id);
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
