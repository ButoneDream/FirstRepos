package com.example.helpoldadmin.service;

import com.example.helpoldadmin.dao.VolDao;
import com.example.helpoldadmin.dao.VolDao;
import com.example.helpoldadmin.model.Vol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VolServiceImpl implements VolService {
    @Autowired
    VolDao volDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Vol> findAll() {
        return volDao.findAll();
    }

    @Override
    public void add(Vol nt) {
        volDao.add(nt);
    }

    @Override
    public void update(Vol nt) {
        volDao.update(nt);
    }

    @Override
    public void deleteByID(int id) {
        volDao.deleteByID(id);
    }

    @Override
    public List<Vol> findByPage(int nowPage, int rows) {
        int begin = (nowPage - 1) * rows;
        return volDao.findByPage(begin, rows);
    }


    @Override
    public Long findTotals() {
        return volDao.findTotals();
    }
}
