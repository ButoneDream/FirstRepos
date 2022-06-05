package com.example.helpoldadmin.dao;

import com.example.helpoldadmin.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper //这个注解表示了该类是一个mybatis的mapper类
@Repository
public interface UserDao {
    //查询所有用户信息
    List<User> findAll();

    //添加用户
    void add(User user);

    //修改用户信息
    void update(User user);

    //根据id删除用户
    void deleteByID(int id);

    //分页查询
    List<User> findByPage(@Param("nowPage") int nowPage, @Param("rows") int rows);

    //查询总条数
    Long findTotals();
}

