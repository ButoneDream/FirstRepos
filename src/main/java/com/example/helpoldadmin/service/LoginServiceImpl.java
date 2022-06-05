package com.example.helpoldadmin.service;

import com.example.helpoldadmin.dao.LoginDao;
import com.example.helpoldadmin.dao.UserDao;
import com.example.helpoldadmin.model.Login;
import com.example.helpoldadmin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginDao loginDao;

    @Override
    public void saveUser(Login u){
        u.setId(UUID.randomUUID().toString());
        u.setIsDel(0);
        loginDao.insertUser(u);
    }

    @Override
    public Login selectUser(Login u){
        if(u.getUname()==null||u.getPwd()==null){
            return null;
        }
        return loginDao.selectOneUser(u);
    }


}
