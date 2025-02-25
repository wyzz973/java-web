package com.sd.tliaswebmanagement.service.impl;

import com.sd.tliaswebmanagement.mapper.DeptMapper;
import com.sd.tliaswebmanagement.pojo.Dept;
import com.sd.tliaswebmanagement.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> finAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(int id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        //补全创建时间、修改时间
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }


}
