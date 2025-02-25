package com.sd.tliaswebmanagement.service;

import com.sd.tliaswebmanagement.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptService {

    List<Dept> finAll();

    void deleteById(int id);

    void add(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
}
