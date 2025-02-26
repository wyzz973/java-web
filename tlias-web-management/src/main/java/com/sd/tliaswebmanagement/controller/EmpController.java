package com.sd.tliaswebmanagement.controller;

import com.sd.tliaswebmanagement.pojo.Emp;
import com.sd.tliaswebmanagement.pojo.EmpQueryParam;
import com.sd.tliaswebmanagement.pojo.PageResult;
import com.sd.tliaswebmanagement.pojo.Result;
import com.sd.tliaswebmanagement.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RequestMapping("/emps")
@RestController()
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping()
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer pageSize,
//                       String name,
//                       Integer gender,
//                       @DateTimeFormat(pattern = "YYYY-MM-DD") LocalDate begin,
//                       @DateTimeFormat(pattern = "YYYY-MM-DD") LocalDate end
//
//    ){
//        log.info("分页查询，{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
//        PageResult<Emp> pageResult = empService.page(page,pageSize,name,gender,begin,end);
//        return Result.success(pageResult);
//    }
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询，{}", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }


    //新增员工

    @PostMapping()
    public Result save(@RequestBody Emp emp){
        log.info("新增员工：{}",emp);
        empService.save(emp);
        return Result.success();
    }
}
