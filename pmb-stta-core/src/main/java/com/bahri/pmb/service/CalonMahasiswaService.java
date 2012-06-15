package com.bahri.pmb.service;

import com.bahri.pmb.domain.CalonMahasiswa;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/11/12
 * Time: 12:09 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CalonMahasiswaService {

    List<CalonMahasiswa> getAll();
    public void save(CalonMahasiswa calonMahasiswa);
    public void delete(CalonMahasiswa calonMahasiswa);
    public void deleteMore(CalonMahasiswa[] calonMahasiswas);
    public CalonMahasiswa findCalonMahasiswa(Long id);
    public List<CalonMahasiswa> findCalonMahasiswas();
    public Long countCalonMahasiswas();
}
