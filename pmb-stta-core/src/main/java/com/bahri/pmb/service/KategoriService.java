package com.bahri.pmb.service;

import com.bahri.pmb.domain.Kategori;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/15/12
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
public interface KategoriService {

    public void save(Kategori kategori);
    public void delete(Kategori kategori);
    public void deleteMore(Kategori[] kategoris);
    public Kategori findKategori(Long id);
    public List<Kategori> findKategoris();
    public Long countKategoris();
}
