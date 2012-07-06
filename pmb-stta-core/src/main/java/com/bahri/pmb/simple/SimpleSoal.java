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
    private Long idKategori;
    private String pertanyaan;
    private String jawabanA;
    private String jawabanB;
    private String jawabanC;
    private String jawabanD;
    private String kebenaran;


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
        if(super.getId()!=null)
        soal.setId(super.getId());
        soal.setPertanyaan(pertanyaan);
        Kategori kategori=new Kategori();
        kategori.setId(idKategori);
        soal.setKategori(kategori);
        List<Jawaban> listJawaban=new ArrayList<Jawaban>();
        Jawaban jwA=new Jawaban();
        jwA.setPilihan(jawabanA);
        jwA.setKebenaran((kebenaran.equals("A")?true:false));
        listJawaban.add(jwA);
        Jawaban jwB=new Jawaban();
        jwB.setPilihan(jawabanB);
        jwB.setKebenaran((kebenaran.equals("B")?true:false));
        listJawaban.add(jwB);
        Jawaban jwC=new Jawaban();
        jwC.setPilihan(jawabanC);
        jwC.setKebenaran((kebenaran.equals("C")?true:false));
        listJawaban.add(jwC);
        Jawaban jwD=new Jawaban();
        jwD.setPilihan(jawabanD);
        jwD.setKebenaran((kebenaran.equals("D")?true:false));
        listJawaban.add(jwD);

        soal.setJawabans(listJawaban);
        return soal;
    }
}
