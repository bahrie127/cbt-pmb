package com.bahri.pmb.service;

import com.bahri.pmb.domain.JenisSoal;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/15/12
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
public interface JenisSoalService {

    public void save(JenisSoal jenisSoal);
    public void delete(JenisSoal jenisSoal);
    public void deleteMore(JenisSoal[] jenisSoals);
    public JenisSoal findJenisSoal(Long id);
    public List<JenisSoal> findJenisSoals();
    public Long countJenisSoals();
}
