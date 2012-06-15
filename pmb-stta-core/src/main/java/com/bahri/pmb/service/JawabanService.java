package com.bahri.pmb.service;

import com.bahri.pmb.domain.Jawaban;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/15/12
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */
public interface JawabanService {

    public void save(Jawaban jawaban);
    public void delete(Jawaban jawaban);
    public void deleteMore(Jawaban[] jawabans);
    public Jawaban findJawaban(Long id);
    public List<Jawaban> findJawabans();
    public Long countJawabans();
}
