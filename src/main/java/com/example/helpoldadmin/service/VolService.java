package com.example.helpoldadmin.service;

import com.example.helpoldadmin.model.Vol;

import java.util.List;

public interface VolService {
    //查询所有
    List<Vol> findAll();

    //添加
    void add(Vol bs);

    //修改
    void update(Vol bs);

    //删除
    void deleteByID(int id);

    //分页查询
    List<Vol> findByPage(int nowPage, int rows);

    //查询总条数
    Long findTotals();
}
