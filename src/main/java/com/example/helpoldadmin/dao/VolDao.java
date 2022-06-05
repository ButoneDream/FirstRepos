package com.example.helpoldadmin.dao;

import com.example.helpoldadmin.model.Vol;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VolDao {
    //查询所有信息
    List<Vol> findAll();

    //添加
    void add(Vol bs);

    //修改
    void update(Vol bs);

    //根据id删除
    void deleteByID(int id);

    //分页查询
    List<Vol> findByPage(@Param("nowPage") int nowPage, @Param("rows") int rows);

    //查询总条数
    Long findTotals();
}

