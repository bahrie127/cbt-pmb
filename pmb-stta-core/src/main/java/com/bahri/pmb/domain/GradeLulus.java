package com.bahri.pmb.domain;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 7/16/12
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "grade_lulus")
public class GradeLulus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "grade_lulus_id")
    private Long id;
    
    @Column(name = "jurusan",nullable = false)
    private String jurusan;

    @Column(name = "batas_verbal",nullable = false)
    private Float batasVerbal;

    @Column(name = "batas_numerik",nullable = false)
    private Float batasNumerik;

    @Column(name = "batas_logika",nullable = false)
    private Float batasLogika;

    @Column(name = "batas_gambar",nullable = false)
    private Float batasGambar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public Float getBatasVerbal() {
        return batasVerbal;
    }

    public void setBatasVerbal(Float batasVerbal) {
        this.batasVerbal = batasVerbal;
    }

    public Float getBatasNumerik() {
        return batasNumerik;
    }

    public void setBatasNumerik(Float batasNumerik) {
        this.batasNumerik = batasNumerik;
    }

    public Float getBatasLogika() {
        return batasLogika;
    }

    public void setBatasLogika(Float batasLogika) {
        this.batasLogika = batasLogika;
    }

    public Float getBatasGambar() {
        return batasGambar;
    }

    public void setBatasGambar(Float batasGambar) {
        this.batasGambar = batasGambar;
    }
}
