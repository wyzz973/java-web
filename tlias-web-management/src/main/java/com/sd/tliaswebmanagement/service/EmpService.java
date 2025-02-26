package com.sd.tliaswebmanagement.service;

import com.sd.tliaswebmanagement.pojo.Emp;
import com.sd.tliaswebmanagement.pojo.EmpQueryParam;
import com.sd.tliaswebmanagement.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public interface EmpService {
    //    PageResult<Emp> page(Integer page, Integer pageSize,String name,
//                         Integer gender,
//                         LocalDate begin,
//                         LocalDate end);
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    public  void save(Emp emp);
}
