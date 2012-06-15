package com.bahri.pmb.service;

import com.bahri.pmb.domain.PengerjaanSoal;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/15/12
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PengerjaanSoalService {

    public void save(PengerjaanSoal pengerjaanSoal);
    public void delete(PengerjaanSoal pengerjaanSoal);
    public void deleteMore(PengerjaanSoal[] pengerjaanSoals);
    public PengerjaanSoal findPengerjaanSoal(Long id);
    public List<PengerjaanSoal> findPengerjaanSoals();
    public Long countPengerjaanSoals();
}
