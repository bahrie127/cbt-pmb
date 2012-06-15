package com.bahri.pmb.service.impl;

import com.bahri.pmb.domain.PengerjaanSoal;
import com.bahri.pmb.service.PengerjaanSoalService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/15/12
 * Time: 11:37 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("pengerjaanSoalService")
@Transactional
public class PengerjaanSoalServiceImpl implements PengerjaanSoalService{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(PengerjaanSoal pengerjaanSoal) {
        sessionFactory.getCurrentSession().saveOrUpdate(pengerjaanSoal);
    }

    @Override
    public void delete(PengerjaanSoal pengerjaanSoal) {
        if(pengerjaanSoal!=null)
            sessionFactory.getCurrentSession().delete(pengerjaanSoal);
    }

    @Override
    public void deleteMore(PengerjaanSoal[] pengerjaanSoals) {
        if(pengerjaanSoals!=null){
            for(PengerjaanSoal pengerjaanSoal:pengerjaanSoals){
                delete(pengerjaanSoal);
            }
        }
    }

    @Override
    public PengerjaanSoal findPengerjaanSoal(Long id) {
        return (PengerjaanSoal) sessionFactory.getCurrentSession().get(PengerjaanSoal.class,id);
    }

    @Override
    public List<PengerjaanSoal> findPengerjaanSoals() {
        return sessionFactory.getCurrentSession().createQuery("from PengerjaanSoal o order by o.id").list();
    }

    @Override
    public Long countPengerjaanSoals() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count (o) from PengerjaanSoal o").uniqueResult();
    }
}
