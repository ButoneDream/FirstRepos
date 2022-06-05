package com.example.helpoldadmin.service;

import com.example.helpoldadmin.dao.NoticeDao;
import com.example.helpoldadmin.dao.NoticeDao;
import com.example.helpoldadmin.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeDao noticeDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Notice> findAll() {
        return noticeDao.findAll();
    }

    @Override
    public void add(Notice nt) {
        noticeDao.add(nt);
    }

    @Override
    public void update(Notice nt) {
        noticeDao.update(nt);
    }

    @Override
    public void deleteByID(int id) {
        noticeDao.deleteByID(id);
    }

    @Override
    public List<Notice> findByPage(int nowPage, int rows) {
        int begin = (nowPage - 1) * rows;
        return noticeDao.findByPage(begin, rows);
    }


    @Override
    public Long findTotals() {
        return noticeDao.findTotals();
    }
}
