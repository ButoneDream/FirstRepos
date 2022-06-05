package com.example.helpoldadmin.controller;

import com.example.helpoldadmin.dto.LoginDto;
import com.example.helpoldadmin.dto.RegisterDto;
import com.example.helpoldadmin.model.Login;
import com.example.helpoldadmin.model.User;
import com.example.helpoldadmin.service.LoginService;
import com.example.helpoldadmin.service.UserService;
import com.example.helpoldadmin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin //解决跨域问题
@RestController//@Controller 代表这个类会被springboot 接管
//被@Controller这个注解的类，中的所有方法，如果返回值是String，并且有具体的页面可以跳转，那么就会被视图解析器解析
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/save")//用@RequestMapping，则什么请求类型都可以
    //restful接口风格，可以用不同的请求方式实现不同的效果
    //使用@PathVariable注解，让方法参数的值对应绑到一个URL模板变量上
    public String saveUser(@RequestBody RegisterDto regDto){
        if(regDto ==null){
            return "操作失败";
        }
        if(regDto.getUsername()==null|| regDto.getPassword()==null|| regDto.getPhone()==null){
            return "操作失败";
        }
        Login l=new Login();
        l.setUname(regDto.getUsername());
        l.setPwd(regDto.getPassword());
        l.setPhone(regDto.getPhone());
        if(!(loginService.selectUser(l)==null)){
            return "此账号与密码已重复";
        }
        loginService.saveUser(l);
        return "操作成功";
    }

    @PostMapping("/login")
    public String loginIn(@RequestBody LoginDto userLoginDto){
        if(userLoginDto==null){
            return "操作失败";
        }
        Login user=new Login();
        user.setUname(userLoginDto.getUsername());
        user.setPwd(userLoginDto.getPassword());
        if(loginService.selectUser(user)==null){
            return "无此账号";
        }
        return "登录成功";
    }
}

