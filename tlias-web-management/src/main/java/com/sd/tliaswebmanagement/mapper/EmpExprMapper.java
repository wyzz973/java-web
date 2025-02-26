package com.sd.tliaswebmanagement.mapper;

import com.sd.tliaswebmanagement.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    void insertBatch(List<EmpExpr> exprList);
}
