package com.bahri.pmb.domain;

import com.bahri.pmb.domain.enumeration.EnumJawaban;

import javax.persistence.*;
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
    private Long id;

    @Column(name = "pertanyaan",nullable = false)
    private String pertanyaan;

    @ManyToOne
    @JoinColumn(name = "kategori_",nullable = false)
    private Kategori kategori;

    @Column(name = "is_view",nullable = true)
    private Long isView;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "soal_id")
    private List<Jawaban> jawabans;

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
}
