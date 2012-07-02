package com.bahri.pmb.service.impl;

import com.bahri.pmb.domain.PenampungSoal;
import com.bahri.pmb.domain.Setting;
import com.bahri.pmb.service.PenampungSoalService;
import com.bahri.pmb.service.SettingService;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/22/12
 * Time: 10:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("penampungSoalService")
@Transactional
public class PenampungSoalServiceImpl implements PenampungSoalService{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(PenampungSoal penampungSoal) {
        sessionFactory.getCurrentSession().saveOrUpdate(penampungSoal);
    }

    @Override
    public PenampungSoal getByUjian(Long idUjian) {
        PenampungSoal penampungSoal=(PenampungSoal) sessionFactory.getCurrentSession().createQuery("from PenampungSoal o where o.idUjian=:idUjian").setParameter("idUjian",idUjian).uniqueResult();
        Hibernate.initialize(penampungSoal.getSoalList());
        return penampungSoal;
    }
}
