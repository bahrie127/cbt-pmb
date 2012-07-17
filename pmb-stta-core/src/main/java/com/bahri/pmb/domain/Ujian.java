package com.bahri.pmb.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 3/27/12
 * Time: 5:43 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "ujian")
public class Ujian {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ujian_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "calon_mahasiswa_id",nullable = false)
    private CalonMahasiswa calonMahasiswa;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "pengerjaan_soal_list",
            joinColumns = {@JoinColumn(table = "ujian",name = "ujian_id")},
            inverseJoinColumns = {@JoinColumn(table = "pengerjaan_soal",name = "pengerjaan_soal_id")}
    )
    private List<PengerjaanSoal> pengerjaanSoalList;

    @Column(name = "hasil",nullable = true)
    private Float hasil;

    @Column(name = "nilai_verbal",nullable = true)
    private Float nilaiVerbal;

    @Column(name = "nilai_numerik",nullable = true)
    private Float nilaiNumerik;

    @Column(name = "nilai_logika",nullable = true)
    private Float nilaiLogika;

    @Column(name = "nilai_gambar",nullable = true)
    private Float nilaiGambar;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CalonMahasiswa getCalonMahasiswa() {
        return calonMahasiswa;
    }

    public void setCalonMahasiswa(CalonMahasiswa calonMahasiswa) {
        this.calonMahasiswa = calonMahasiswa;
    }

    public List<PengerjaanSoal> getPengerjaanSoalList() {
        return pengerjaanSoalList;
    }

    public void setPengerjaanSoalList(List<PengerjaanSoal> pengerjaanSoalList) {
        this.pengerjaanSoalList = pengerjaanSoalList;
    }

    public Float getHasil() {
        return hasil;
    }

    public void setHasil(Float hasil) {
        this.hasil = hasil;
    }

    public Float getNilaiVerbal() {
        return nilaiVerbal;
    }

    public void setNilaiVerbal(Float nilaiVerbal) {
        this.nilaiVerbal = nilaiVerbal;
    }

    public Float getNilaiNumerik() {
        return nilaiNumerik;
    }

    public void setNilaiNumerik(Float nilaiNumerik) {
        this.nilaiNumerik = nilaiNumerik;
    }

    public Float getNilaiLogika() {
        return nilaiLogika;
    }

    public void setNilaiLogika(Float nilaiLogika) {
        this.nilaiLogika = nilaiLogika;
    }

    public Float getNilaiGambar() {
        return nilaiGambar;
    }

    public void setNilaiGambar(Float nilaiGambar) {
        this.nilaiGambar = nilaiGambar;
    }
}
