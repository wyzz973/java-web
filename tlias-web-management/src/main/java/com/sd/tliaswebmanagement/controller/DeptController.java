package com.sd.tliaswebmanagement.controller;

import com.sd.tliaswebmanagement.pojo.Dept;
import com.sd.tliaswebmanagement.pojo.Result;
import com.sd.tliaswebmanagement.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    //    @RequestMapping(value = "/depts",method= RequestMethod.GET)
    @GetMapping()
    public Result list() {
        System.out.println("查询全部部门数据");
        List<Dept> deptList = deptService.finAll();
        return Result.success(deptList);
    }

    @DeleteMapping()
//    public Result delete(HttpServletRequest request) {
//        System.out.println("删除部门数据");
//        String idS = request.getParameter("id");
//        int id = Integer.parseInt(idS);
//        deptService.deleteById(id);
//        System.out.println("删除部门 id ：" + id);
//        return Result.success();
//    }
//    public Result delete(@RequestParam(value = "id",required = false) Integer id) {
//        System.out.println("删除部门数据");
////        deptService.deleteById(id);
//        System.out.println("删除部门 id ：" + id);
//        return Result.success();
//    }
    public Result delete(Integer id) {
        System.out.println("删除部门数据");
        deptService.deleteById(id);
        System.out.println("删除部门 id ：" + id);
        return Result.success();
    }


    @PostMapping()
    public Result add(@RequestBody Dept dept) {
        System.out.println("新增部门数据:"+ dept.getName());
        deptService.add(dept);
        return Result.success();
    }


    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        System.out.println("查询部门 id ：" + id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping()
    public Result update(@RequestBody Dept dept) {
        System.out.println("修改部门数据:"+ dept.getName());
        deptService.update(dept);
        return Result.success();
    }

}
