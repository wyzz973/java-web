package com.sd.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sd.tliaswebmanagement.mapper.EmpExprMapper;
import com.sd.tliaswebmanagement.mapper.EmpMapper;
import com.sd.tliaswebmanagement.pojo.Emp;
import com.sd.tliaswebmanagement.pojo.EmpExpr;
import com.sd.tliaswebmanagement.pojo.EmpQueryParam;
import com.sd.tliaswebmanagement.pojo.PageResult;
import com.sd.tliaswebmanagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize,String name,
//                                Integer gender,
//                                LocalDate begin,
//                                LocalDate end) {
//        /**
//         * 原始分页查询
//
//        Long total = empMapper.count();
//
//        Integer start = (page - 1) * pageSize;
//        List<Emp> rows = empMapper.list(start, pageSize);
//         */
//
//        /**
//         * pageHelper 分页查询
//         */
//
//        PageHelper.startPage(page, pageSize);
//
//        List<Emp> list = empMapper.list(name, gender, begin, end);
//
//        Page<Emp> p = (Page<Emp>)list;
//
//        return new PageResult<Emp>(p.getTotal(),p.getResult());
//
//    }
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        /**
         * 原始分页查询

         Long total = empMapper.count();

         Integer start = (page - 1) * pageSize;
         List<Emp> rows = empMapper.list(start, pageSize);
         */

        /**
         * pageHelper 分页查询
         */

        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        List<Emp> list = empMapper.list(empQueryParam);

        Page<Emp> p = (Page<Emp>) list;

        return new PageResult<Emp>(p.getTotal(), p.getResult());

    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);

        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)){
            //遍历集合，为 empId赋值
            exprList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(exprList);
        }

    }


}
