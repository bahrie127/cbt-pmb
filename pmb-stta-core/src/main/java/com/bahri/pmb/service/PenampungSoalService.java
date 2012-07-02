package com.bahri.pmb.service;

import com.bahri.pmb.domain.PenampungSoal;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/22/12
 * Time: 10:33 PM
 * To change this template use File | PenampungSoals | File Templates.
 */
public interface PenampungSoalService {

    public void save(PenampungSoal penampungSoal);

    public PenampungSoal getByUjian(Long idUjian);
}
