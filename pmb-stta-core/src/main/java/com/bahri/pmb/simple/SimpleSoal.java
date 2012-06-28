package com.bahri.pmb.simple;

import com.bahri.pmb.domain.Jawaban;
import com.bahri.pmb.domain.Kategori;
import com.bahri.pmb.domain.Soal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/18/12
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleSoal extends Soal{
    
    private int nomor;

    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }
}
