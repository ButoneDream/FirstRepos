package com.example.helpoldadmin.service;

import com.example.helpoldadmin.dao.HelpDao;
import com.example.helpoldadmin.dao.HelpDao;
import com.example.helpoldadmin.model.Help;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HelpServiceImpl implements HelpService {
    @Autowired
    HelpDao helpDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Help> findAll() {
        return helpDao.findAll();
    }

    @Override
    public void add(Help nt) {
        helpDao.add(nt);
    }

    @Override
    public void update(Help nt) {
        helpDao.update(nt);
    }

    @Override
    public void deleteByID(int id) {
        helpDao.deleteByID(id);
    }

    @Override
    public List<Help> findByPage(int nowPage, int rows) {
        int begin = (nowPage - 1) * rows;
        return helpDao.findByPage(begin, rows);
    }


    @Override
    public Long findTotals() {
        return helpDao.findTotals();
    }
}
