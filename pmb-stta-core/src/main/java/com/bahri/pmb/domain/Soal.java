package com.bahri.pmb.domain;

import com.bahri.pmb.simple.SimpleSoal;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 3/27/12
 * Time: 5:32 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "soal")
public class Soal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "soal_id")
    private Long id;                      //,columnDefinition="TEXT"

    @Column(name = "pertanyaan",nullable = false,columnDefinition="TEXT")
    private String pertanyaan;

    @ManyToOne
    @JoinColumn(name = "kategori_id",nullable = false)
    private Kategori kategori;

    @Column(name = "is_view",nullable = true)
    private Long isView;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "soal_id")
    private List<Jawaban> jawabans;

    public Soal(Long id, String pertanyaan, Kategori kategori, Long view, List<Jawaban> jawabans) {
        this.id = id;
        this.pertanyaan = pertanyaan;
        this.kategori = kategori;
        isView = view;
        this.jawabans = jawabans;
    }

    public Soal() {
        isView=0L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public Long getView() {
        return isView;
    }

    public void setView(Long view) {
        isView = view;
    }

    public List<Jawaban> getJawabans() {
        return jawabans;
    }

    public void setJawabans(List<Jawaban> jawabans) {
        this.jawabans = jawabans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Soal soal = (Soal) o;

        if (id != null ? !id.equals(soal.id) : soal.id != null) return false;
        if (isView != null ? !isView.equals(soal.isView) : soal.isView != null) return false;
        if (jawabans != null ? !jawabans.equals(soal.jawabans) : soal.jawabans != null) return false;
        if (kategori != null ? !kategori.equals(soal.kategori) : soal.kategori != null) return false;
        if (pertanyaan != null ? !pertanyaan.equals(soal.pertanyaan) : soal.pertanyaan != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pertanyaan != null ? pertanyaan.hashCode() : 0);
        result = 31 * result + (kategori != null ? kategori.hashCode() : 0);
        result = 31 * result + (isView != null ? isView.hashCode() : 0);
        result = 31 * result + (jawabans != null ? jawabans.hashCode() : 0);
        return result;
    }

    public SimpleSoal convertToSimpleSoal(){
        SimpleSoal simpleSoal=new SimpleSoal();
        simpleSoal.setId(id);
        simpleSoal.setPertanyaan(pertanyaan);
        simpleSoal.setIdKategori(kategori.getId());
        simpleSoal.setJawabanA(jawabans.get(0).getPilihan());
        simpleSoal.setJawabanB(jawabans.get(1).getPilihan());
        simpleSoal.setJawabanC(jawabans.get(2).getPilihan());
        simpleSoal.setJawabanD(jawabans.get(3).getPilihan());
        String kebenaran="";
        if(jawabans.get(0).getKebenaran())
            kebenaran="A";
        else if(jawabans.get(1).getKebenaran())
            kebenaran="B";
        else if(jawabans.get(2).getKebenaran())
            kebenaran="C";
        else if(jawabans.get(3).getKebenaran())
            kebenaran="D";
        simpleSoal.setKebenaran(kebenaran);
        return simpleSoal;
    }
}
