package com.bahri.pmb.service.impl;

import com.bahri.pmb.domain.CalonMahasiswa;
import com.bahri.pmb.service.CalonMahasiswaService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/11/12
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("calonMahasiswaService")
@Transactional
public class CalonMahasiswaServiceImpl implements CalonMahasiswaService{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<CalonMahasiswa> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from CalonMahasiswa c").list();
    }
}
