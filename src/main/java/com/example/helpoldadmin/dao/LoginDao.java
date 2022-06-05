package com.example.helpoldadmin.dao;

import com.example.helpoldadmin.model.Login;
import com.example.helpoldadmin.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper //这个注解表示了该类是一个mybatis的mapper类
@Repository
public interface LoginDao {
    //验证用户名和密码
    Login selectOneUser(Login l);
    //注册
    void insertUser(Login l);
}

