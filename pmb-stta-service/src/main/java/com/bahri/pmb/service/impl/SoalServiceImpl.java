package com.bahri.pmb.service.impl;

import com.bahri.pmb.domain.Soal;
import com.bahri.pmb.service.SoalService;
import com.bahri.pmb.simple.SimpleSoal;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/15/12
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("soalService")
@Transactional
public class SoalServiceImpl implements SoalService{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Soal soal) {
        sessionFactory.getCurrentSession().saveOrUpdate(soal);
    }

    @Override
    public void delete(Soal soal) {
        if(soal!=null)
            sessionFactory.getCurrentSession().delete(soal);
    }

    @Override
    public void deleteMore(Soal[] soals) {
        if(soals!=null){
            for(Soal soal:soals){
                delete(soal);
            }
        }
    }

    @Override
    public Soal findSoal(Long id) {
        return (Soal) sessionFactory.getCurrentSession().get(Soal.class,id);
    }

    @Override
    public List<Soal> findSoals() {
        return sessionFactory.getCurrentSession().createQuery("from Soal o order by o.id").list();
    }

    @Override
    public List<SimpleSoal> findSimpleSoals() {
        return sessionFactory.getCurrentSession().createQuery("from Soal o order by o.id").list();
    }

    @Override
    public Long countSoals() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count (o) from Soal o").uniqueResult();
    }
}
