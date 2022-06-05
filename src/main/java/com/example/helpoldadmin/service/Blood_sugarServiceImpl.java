package com.example.helpoldadmin.service;

import com.example.helpoldadmin.dao.Blood_SugarDao;
import com.example.helpoldadmin.model.Blood_Sugar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Blood_sugarServiceImpl implements Blood_sugarService {
    @Autowired
    Blood_SugarDao blood_sugarDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Blood_Sugar> findAll() {
        return blood_sugarDao.findAll();
    }

    @Override
    public void add(Blood_Sugar user) {
        blood_sugarDao.add(user);
    }

    @Override
    public void update(Blood_Sugar user) {
        blood_sugarDao.update(user);
    }

    @Override
    public void deleteByID(int id) {
        blood_sugarDao.deleteByID(id);
    }

    @Override
    public List<Blood_Sugar> findByPage(int nowPage, int rows) {
        int begin = (nowPage - 1) * rows;
        return blood_sugarDao.findByPage(begin, rows);
    }


    @Override
    public Long findTotals() {
        return blood_sugarDao.findTotals();
    }
}
