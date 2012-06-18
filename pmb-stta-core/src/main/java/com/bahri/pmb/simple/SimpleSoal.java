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
public class SimpleSoal {
    
    private Long id;
    private Long idKategori;
    private String pertanyaan;
    private String jawabanA;
    private String jawabanB;
    private String jawabanC;
    private String jawabanD;
    private String kebenaran;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(Long idKategori) {
        this.idKategori = idKategori;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public String getJawabanA() {
        return jawabanA;
    }

    public void setJawabanA(String jawabanA) {
        this.jawabanA = jawabanA;
    }

    public String getJawabanB() {
        return jawabanB;
    }

    public void setJawabanB(String jawabanB) {
        this.jawabanB = jawabanB;
    }

    public String getJawabanC() {
        return jawabanC;
    }

    public void setJawabanC(String jawabanC) {
        this.jawabanC = jawabanC;
    }

    public String getJawabanD() {
        return jawabanD;
    }

    public void setJawabanD(String jawabanD) {
        this.jawabanD = jawabanD;
    }

    public String getKebenaran() {
        return kebenaran;
    }

    public void setKebenaran(String kebenaran) {
        this.kebenaran = kebenaran;
    }
    
    public Soal convertToSoal(){
        Soal soal=new Soal();
        Kategori k=new Kategori();
        k.setId(idKategori);
        soal.setId(id);
        soal.setKategori(k);
        soal.setPertanyaan(pertanyaan);

        Jawaban jbA=new Jawaban();
        jbA.setPilihan(jawabanA);
        jbA.setKebenaran((kebenaran.equals("A")?true:false));

        Jawaban jbB=new Jawaban();
        jbB.setPilihan(jawabanB);
        jbB.setKebenaran((kebenaran.equals("B")?true:false));

        Jawaban jbC=new Jawaban();
        jbC.setPilihan(jawabanC);
        jbC.setKebenaran((kebenaran.equals("C")?true:false));

        Jawaban jbD=new Jawaban();
        jbD.setPilihan(jawabanD);
        jbD.setKebenaran((kebenaran.equals("D")?true:false));

        List<Jawaban> jawabans=new ArrayList<Jawaban>();
        jawabans.add(jbA);
        jawabans.add(jbB);
        jawabans.add(jbC);
        jawabans.add(jbD);

        soal.setJawabans(jawabans);

        return soal;
    }
}
