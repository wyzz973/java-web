package com.sd.tliaswebmanagement.mapper;

import com.sd.tliaswebmanagement.pojo.Emp;
import com.sd.tliaswebmanagement.pojo.EmpExpr;
import com.sd.tliaswebmanagement.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * 原始分页查询
     * @return

    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
    public Long count();
    @Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc limit #{start},#{pageSize}")
    public List<Emp> list(Integer start, Integer pageSize);


    */

  //  @Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")
//    public List<Emp> list(String name,
//                          Integer gender,
//                          LocalDate begin,
//                          LocalDate end);
    public List<Emp> list(EmpQueryParam empQueryParam);
    @Options(useGeneratedKeys = true,keyProperty = "id") //获取生成的主键
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

}
