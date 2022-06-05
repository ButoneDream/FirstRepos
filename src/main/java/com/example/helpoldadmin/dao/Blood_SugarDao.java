package com.example.helpoldadmin.dao;

import com.example.helpoldadmin.model.Blood_Sugar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Blood_SugarDao {
    //查询所有信息
    List<Blood_Sugar> findAll();

    //添加
    void add(Blood_Sugar bs);

    //修改
    void update(Blood_Sugar bs);

    //根据id删除
    void deleteByID(int id);

    //分页查询
    List<Blood_Sugar> findByPage(@Param("nowPage") int nowPage, @Param("rows") int rows);

    //查询总条数
    Long findTotals();
}

