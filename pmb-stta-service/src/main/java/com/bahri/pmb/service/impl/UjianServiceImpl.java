package com.bahri.pmb.service.impl;

import com.bahri.pmb.domain.CalonMahasiswa;
import com.bahri.pmb.domain.PengerjaanSoal;
import com.bahri.pmb.domain.Ujian;
import com.bahri.pmb.service.UjianService;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public void update(Ujian ujian) {
        sessionFactory.getCurrentSession().update(ujian);
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
    public Ujian findUjianByPendaftaran(CalonMahasiswa calonMahasiswa) {
        Ujian ujian=(Ujian) sessionFactory.getCurrentSession().createQuery("from Ujian o where o.calonMahasiswa=:calonMahasiswa").setParameter("calonMahasiswa",calonMahasiswa).uniqueResult();
        if(ujian!=null)
        Hibernate.initialize(ujian.getPengerjaanSoalList());
        return ujian;
    }

    @Override
    public List<PengerjaanSoal> findPengerjaanSoalByPendaftaran(CalonMahasiswa calonMahasiswa) {
        return sessionFactory.getCurrentSession().createQuery("select o.pengerjaanSoalList from Ujian o  where o.calonMahasiswa=:calonMahasiswa").setParameter("calonMahasiswa",calonMahasiswa).list();
    }

    @Override
    public List<Ujian> findUjians() {
        return sessionFactory.getCurrentSession().createQuery("from Ujian o order by o.id").list();
    }

    @Override
    public List<Ujian> findUjians(int pilihan, String jurusan) {
        if(pilihan==1){
            return sessionFactory.getCurrentSession().createQuery("from Ujian o where o.calonMahasiswa.pilihanPertama=:pilihanPertama order by o.hasil desc ").setParameter("pilihanPertama",jurusan).list();
        }else if(pilihan==2){
            return sessionFactory.getCurrentSession().createQuery("from Ujian o where o.calonMahasiswa.pilihanKedua=:pilihanKedua order by o.hasil desc ").setParameter("pilihanKedua",jurusan).list();
        }
        return new ArrayList<Ujian>();
    }

    @Override
    public Long countUjians() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count (o) from Ujian o").uniqueResult();
    }

    @Override
    public Long countUjians(int pilihan, String jurusan) {
        if(pilihan==1){
            return (Long) sessionFactory.getCurrentSession().createQuery("select count (o) from Ujian o where o.calonMahasiswa.pilihanPertama=:pilihanPertama").setParameter("pilihanPertama",jurusan).uniqueResult();
        }else if(pilihan==2){
            return (Long) sessionFactory.getCurrentSession().createQuery("select count (o) from Ujian o where o.calonMahasiswa.pilihanKedua=:pilihanKedua").setParameter("pilihanKedua",jurusan).uniqueResult();
        }
        return 0l;
    }

    @Override
    public Double rataNilaiBidang(int pilihan, String jurusan, int bidang) {
        if(pilihan==1){
            if(bidang==1)
            return (Double) sessionFactory.getCurrentSession().createQuery("select avg(o.nilaiVerbal) from Ujian o where o.calonMahasiswa.pilihanPertama=:pilihanPertama").setParameter("pilihanPertama",jurusan).uniqueResult();
            if(bidang==2)
                return (Double) sessionFactory.getCurrentSession().createQuery("select avg(o.nilaiNumerik) from Ujian o where o.calonMahasiswa.pilihanPertama=:pilihanPertama").setParameter("pilihanPertama",jurusan).uniqueResult();
            if(bidang==3)
                return (Double) sessionFactory.getCurrentSession().createQuery("select avg(o.nilaiLogika) from Ujian o where o.calonMahasiswa.pilihanPertama=:pilihanPertama").setParameter("pilihanPertama",jurusan).uniqueResult();
            if(bidang==4)
                return (Double) sessionFactory.getCurrentSession().createQuery("select avg(o.nilaiGambar) from Ujian o where o.calonMahasiswa.pilihanPertama=:pilihanPertama").setParameter("pilihanPertama",jurusan).uniqueResult();
        }else if(pilihan==2){
            if(bidang==1)
            return (Double) sessionFactory.getCurrentSession().createQuery("select avg(o.nilaiVerbal) from Ujian o where o.calonMahasiswa.pilihanKedua=:pilihanKedua").setParameter("pilihanKedua",jurusan).uniqueResult();
            if(bidang==2)
                return (Double) sessionFactory.getCurrentSession().createQuery("select avg(o.nilaiNumerik) from Ujian o where o.calonMahasiswa.pilihanKedua=:pilihanKedua").setParameter("pilihanKedua",jurusan).uniqueResult();
            if(bidang==3)
                return (Double) sessionFactory.getCurrentSession().createQuery("select avg(o.nilaiLogika) from Ujian o where o.calonMahasiswa.pilihanKedua=:pilihanKedua").setParameter("pilihanKedua",jurusan).uniqueResult();
            if(bidang==4)
                return (Double) sessionFactory.getCurrentSession().createQuery("select avg(o.nilaiGambar) from Ujian o where o.calonMahasiswa.pilihanKedua=:pilihanKedua").setParameter("pilihanKedua",jurusan).uniqueResult();
        }
        return 0d;
    }
}
