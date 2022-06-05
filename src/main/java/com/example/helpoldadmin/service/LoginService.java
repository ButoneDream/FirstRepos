package com.example.helpoldadmin.service;

import com.example.helpoldadmin.model.Login;
import com.example.helpoldadmin.model.User;

import java.util.List;

public interface LoginService {
    //验证用户名和密码
    Login selectUser(Login l);
    //注册
    void saveUser(Login l);
}
