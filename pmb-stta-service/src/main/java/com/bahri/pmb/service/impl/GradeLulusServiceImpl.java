package com.bahri.pmb.service.impl;

import com.bahri.pmb.domain.GradeLulus;
import com.bahri.pmb.service.GradeLulusService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/22/12
 * Time: 10:33 PM
 * To change this template use File | GradeLuluss | File Templates.
 */
@Service("gradeLulusService")
@Transactional
public class GradeLulusServiceImpl implements GradeLulusService{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(GradeLulus gradeLulus) {
        sessionFactory.getCurrentSession().saveOrUpdate(gradeLulus);
    }

    @Override
    public GradeLulus getGradeLulus() {
        return (GradeLulus) sessionFactory.getCurrentSession().get(GradeLulus.class,1L);
    }
}
