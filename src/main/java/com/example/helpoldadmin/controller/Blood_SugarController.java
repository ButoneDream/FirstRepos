package com.example.helpoldadmin.controller;

import com.example.helpoldadmin.model.Blood_Sugar;
import com.example.helpoldadmin.service.Blood_sugarService;
import com.example.helpoldadmin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
//import sun.security.ssl.SSLContextImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("bs")
@CrossOrigin //解决跨域问题
public class Blood_SugarController {
//    @Qualifier("Blood_sugarServiceImpl")
    @Autowired
    private Blood_sugarService blood_sugarService;

    //查询所有用户
    @GetMapping("/findAll")
    public List<Blood_Sugar> findAll() {
        return blood_sugarService.findAll();
    }

    //添加用户
    @PostMapping("/add")
    public Result add(@RequestBody Blood_Sugar bs) {
        Result result = new Result();
        try {
            blood_sugarService.add(bs);
            result.setMsg("添加成功!");
        } catch (Exception e) {
            result.status = false;
            result.setMsg("保存失败,请稍后再试...");
        }
        return result;
    }

    //修改用户
    @PostMapping("/update")
    public Result update(@RequestBody Blood_Sugar bs) {
        Result result = new Result();
        try {
            blood_sugarService.update(bs);
            result.setMsg("修改成功!");
        } catch (Exception e) {
            result.status = false;
            result.setMsg("修改失败,请稍后再试...");
        }
        return result;
    }

    //删除指定用户
    @GetMapping("/deleteByID")
    public Result deleteByID(int id) {
        Result result = new Result();
        try {
            blood_sugarService.deleteByID(id);
            result.setMsg("删除成功!");
        } catch (Exception e) {
            result.status = false;
            result.setMsg("删除失败,请稍后再试...");
        }
        return result;
    }

    //分页查询
    @GetMapping("/findByPage")
    public Map<String, Object> findByPage(Integer nowPage, Integer rows) {
        HashMap<String, Object> result = new HashMap<>();
        nowPage = nowPage == null ? 1 : nowPage;
        rows = rows == null ? 4 : rows;
        List<Blood_Sugar> bs = blood_sugarService.findByPage(nowPage, rows);
        Long totals = blood_sugarService.findTotals();
        result.put("bs", bs);
        result.put("total", totals);
        return result;
    }
}

