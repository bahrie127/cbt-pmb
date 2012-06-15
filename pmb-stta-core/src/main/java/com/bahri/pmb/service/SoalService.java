package com.bahri.pmb.service;

import com.bahri.pmb.domain.Soal;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/15/12
 * Time: 11:25 AM
 * To change this template use File | Settings | File Templates.
 */
public interface SoalService {
    public void save(Soal soal);
    public void delete(Soal soal);
    public void deleteMore(Soal[] soals);
    public Soal findSoal(Long id);
    public List<Soal> findSoals();
    public Long countSoals();
}
