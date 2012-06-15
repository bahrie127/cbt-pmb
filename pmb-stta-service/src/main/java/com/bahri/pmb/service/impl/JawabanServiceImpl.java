package com.bahri.pmb.service.impl;

import com.bahri.pmb.domain.Jawaban;
import com.bahri.pmb.service.JawabanService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/15/12
 * Time: 11:36 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("jawabanService")
@Transactional
public class JawabanServiceImpl implements JawabanService{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Jawaban jawaban) {
        sessionFactory.getCurrentSession().saveOrUpdate(jawaban);
    }

    @Override
    public void delete(Jawaban jawaban) {
        if(jawaban!=null)
            sessionFactory.getCurrentSession().delete(jawaban);
    }

    @Override
    public void deleteMore(Jawaban[] jawabans) {
        if(jawabans!=null){
            for(Jawaban jawaban:jawabans){
                delete(jawaban);
            }
        }
    }

    @Override
    public Jawaban findJawaban(Long id) {
        return (Jawaban) sessionFactory.getCurrentSession().get(Jawaban.class,id);
    }

    @Override
    public List<Jawaban> findJawabans() {
        return sessionFactory.getCurrentSession().createQuery("from Jawaban o order by o.id").list();
    }

    @Override
    public Long countJawabans() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count (o) from Jawaban o").uniqueResult();
    }
}
