package com.bahri.pmb.service.impl;

import com.bahri.pmb.domain.CalonMahasiswa;
import com.bahri.pmb.service.CalonMahasiswaService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Override
    public void save(CalonMahasiswa calonMahasiswa) {
        sessionFactory.getCurrentSession().saveOrUpdate(calonMahasiswa);
    }

    @Override
    public void delete(CalonMahasiswa calonMahasiswa) {
        if(calonMahasiswa!=null)
            sessionFactory.getCurrentSession().delete(calonMahasiswa);
    }

    @Override
    public void deleteMore(CalonMahasiswa[] calonMahasiswas) {
        if(calonMahasiswas!=null){
            for(CalonMahasiswa calonMahasiswa:calonMahasiswas){
                delete(calonMahasiswa);
            }
        }
    }

    @Override
    public CalonMahasiswa findCalonMahasiswa(Long id) {
        return (CalonMahasiswa) sessionFactory.getCurrentSession().get(CalonMahasiswa.class,id);
    }

    @Override
    public List<CalonMahasiswa> findCalonMahasiswas() {
        return sessionFactory.getCurrentSession().createQuery("from CalonMahasiswa o order by o.id").list();
    }

    @Override
    public List<CalonMahasiswa> findCalonMahasiswas(int pilihan, String jurusan) {
        if(pilihan==1){
            return sessionFactory.getCurrentSession().createQuery("from CalonMahasiswa o where o.pilihanPertama=:pilihanPertama").setParameter("pilihanPertama",jurusan).list();
        }else if(pilihan==2){
            return sessionFactory.getCurrentSession().createQuery("from CalonMahasiswa o where o.pilihanKedua=:pilihanKedua").setParameter("pilihanKedua",jurusan).list();
        }
        return new ArrayList<CalonMahasiswa>();
    }

    @Override
    public Long countCalonMahasiswas() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count (o) from CalonMahasiswa o").uniqueResult();
    }

    @Override
    public Long countCalonMahasiswas(int pilihan, String jurusan) {
        if(pilihan==1){
            return (Long) sessionFactory.getCurrentSession().createQuery("select count (o) from CalonMahasiswa o where o.pilihanPertama=:pilihanPertama").setParameter("pilihanPertama",jurusan).uniqueResult();
        }else if(pilihan==2){
            return (Long) sessionFactory.getCurrentSession().createQuery("select count (o) from CalonMahasiswa o where o.pilihanKedua=:pilihanKedua").setParameter("pilihanKedua",jurusan).uniqueResult();
        }
        return 0l;
    }
}
