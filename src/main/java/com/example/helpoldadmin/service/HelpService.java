package com.example.helpoldadmin.service;

import com.example.helpoldadmin.model.Help;

import java.util.List;

public interface HelpService {
    //查询所有
    List<Help> findAll();

    //添加
    void add(Help bs);

    //修改
    void update(Help bs);

    //删除
    void deleteByID(int id);

    //分页查询
    List<Help> findByPage(int nowPage, int rows);

    //查询总条数
    Long findTotals();
}
