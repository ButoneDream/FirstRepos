package com.example.helpoldadmin.service;

import com.example.helpoldadmin.model.Blood_Sugar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Blood_sugarService {
    //查询所有
    List<Blood_Sugar> findAll();

    //添加
    void add(Blood_Sugar bs);

    //修改
    void update(Blood_Sugar bs);

    //删除
    void deleteByID(int id);

    //分页查询
    List<Blood_Sugar> findByPage(int nowPage, int rows);

    //查询总条数
    Long findTotals();
}
