package com.example.helpoldadmin.dao;

import com.example.helpoldadmin.model.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NoticeDao {
    //查询所有信息
    List<Notice> findAll();

    //添加
    void add(Notice bs);

    //修改
    void update(Notice bs);

    //根据id删除
    void deleteByID(int id);

    //分页查询
    List<Notice> findByPage(@Param("nowPage") int nowPage, @Param("rows") int rows);

    //查询总条数
    Long findTotals();
}

