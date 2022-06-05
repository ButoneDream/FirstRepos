package com.example.helpoldadmin.service;

import com.example.helpoldadmin.model.Notice;

import java.util.List;

public interface NoticeService {
    //查询所有
    List<Notice> findAll();

    //添加
    void add(Notice bs);

    //修改
    void update(Notice bs);

    //删除
    void deleteByID(int id);

    //分页查询
    List<Notice> findByPage(int nowPage, int rows);

    //查询总条数
    Long findTotals();
}
