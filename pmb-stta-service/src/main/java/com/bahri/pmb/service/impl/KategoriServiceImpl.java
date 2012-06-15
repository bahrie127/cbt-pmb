package com.bahri.pmb.service.impl;

import com.bahri.pmb.domain.Kategori;
import com.bahri.pmb.service.KategoriService;
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
@Service("kategoriService")
@Transactional
public class KategoriServiceImpl implements KategoriService{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Kategori kategori) {
        sessionFactory.getCurrentSession().saveOrUpdate(kategori);
    }

    @Override
    public void delete(Kategori kategori) {
        if(kategori!=null)
            sessionFactory.getCurrentSession().delete(kategori);
    }

    @Override
    public void deleteMore(Kategori[] kategoris) {
        if(kategoris!=null){
            for(Kategori kategori:kategoris){
                delete(kategori);
            }
        }
    }

    @Override
    public Kategori findKategori(Long id) {
        return (Kategori) sessionFactory.getCurrentSession().get(Kategori.class,id);
    }

    @Override
    public List<Kategori> findKategoris() {
        return sessionFactory.getCurrentSession().createQuery("from Kategori o order by o.id").list();
    }

    @Override
    public Long countKategoris() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count (o) from Kategori o").uniqueResult();
    }
}
