package com.bahri.pmb.service.impl;

import com.bahri.pmb.domain.Ujian;
import com.bahri.pmb.service.UjianService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/15/12
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("ujianService")
@Transactional
public class UjianServiceImpl implements UjianService{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Ujian ujian) {
        sessionFactory.getCurrentSession().saveOrUpdate(ujian);
    }

    @Override
    public void delete(Ujian ujian) {
        if(ujian!=null)
            sessionFactory.getCurrentSession().delete(ujian);
    }

    @Override
    public void deleteMore(Ujian[] ujians) {
        if(ujians!=null){
            for(Ujian ujian:ujians){
                delete(ujian);
            }
        }
    }

    @Override
    public Ujian findUjian(Long id) {
        return (Ujian) sessionFactory.getCurrentSession().get(Ujian.class,id);
    }

    @Override
    public List<Ujian> findUjians() {
        return sessionFactory.getCurrentSession().createQuery("from Ujian o order by o.id").list();
    }

    @Override
    public Long countUjians() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count (o) from Ujian o").uniqueResult();
    }
}
