package com.example.helpoldadmin.controller;

import com.example.helpoldadmin.model.Help;
import com.example.helpoldadmin.service.HelpService;
import com.example.helpoldadmin.service.HelpService;
import com.example.helpoldadmin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("hp")
@CrossOrigin //解决跨域问题
public class HelpController {
//    @Qualifier("Blood_sugarServiceImpl")
    @Autowired
    private HelpService helpService;

    //查询所有数据
    @GetMapping("/findAll")
    public List<Help> findAll() {
        return helpService.findAll();
    }

    //添加数据
    @PostMapping("/add")
    public Result add(@RequestBody Help bs) {
        Result result = new Result();
        try {
            helpService.add(bs);
            result.setMsg("添加成功!");
        } catch (Exception e) {
            result.status = false;
            result.setMsg("保存失败,请稍后再试...");
        }
        return result;
    }

    //修改数据
    @PostMapping("/update")
    public Result update(@RequestBody Help bs) {
        Result result = new Result();
        try {
            helpService.update(bs);
            result.setMsg("修改成功!");
        } catch (Exception e) {
            result.status = false;
            result.setMsg("修改失败,请稍后再试...");
        }
        return result;
    }

    //删除指定数据
    @GetMapping("/deleteByID")
    public Result deleteByID(int id) {
        Result result = new Result();
        try {
            helpService.deleteByID(id);
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
        List<Help> hp = helpService.findByPage(nowPage, rows);
        Long totals = helpService.findTotals();
        result.put("hp", hp);
        result.put("total", totals);
        return result;
    }
}

