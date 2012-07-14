package com.bahri.pmb.service.impl;

import com.bahri.pmb.domain.JenisSoal;
import com.bahri.pmb.service.JenisSoalService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/15/12
 * Time: 11:33 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("jensiSoalService")
@Transactional
public class JenisSoalServiceImpl implements JenisSoalService{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(JenisSoal jenisSoal) {
        sessionFactory.getCurrentSession().saveOrUpdate(jenisSoal);
    }

    @Override
    public void delete(JenisSoal jenisSoal) {
        if(jenisSoal!=null)
            sessionFactory.getCurrentSession().delete(jenisSoal);
    }

    @Override
    public void deleteMore(JenisSoal[] jenisSoals) {
        if(jenisSoals!=null){
            for(JenisSoal jenisSoal:jenisSoals){
                delete(jenisSoal);
            }
        }
    }

    @Override
    public JenisSoal findJenisSoal(Long id) {
        return (JenisSoal) sessionFactory.getCurrentSession().get(JenisSoal.class,id);
    }

    @Override
    public List<JenisSoal> findJenisSoals() {
        return sessionFactory.getCurrentSession().createQuery("from JenisSoal o order by o.id").list();
    }

    @Override
    public Long countJenisSoals() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count (o) from JenisSoal o").uniqueResult();
    }
}
