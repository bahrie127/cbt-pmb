package com.bahri.pmb.service;

import com.bahri.pmb.domain.CalonMahasiswa;
import com.bahri.pmb.domain.Ujian;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/15/12
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UjianService {
    public void save(Ujian ujian);
    public void update(Ujian ujian);
    public void delete(Ujian ujian);
    public void deleteMore(Ujian[] ujians);
    public Ujian findUjian(Long id);
    public Ujian findUjianByPendaftaran(CalonMahasiswa calonMahasiswa);
    public List<Ujian> findUjians();

    public Long countUjians();
}
