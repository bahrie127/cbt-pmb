package com.bahri.pmb.domain;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/21/12
 * Time: 3:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "setting")
public class Setting {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "jumlah_soal_tampil",nullable = false)
    private int jumlahSoalTampil;

    //dalam jam
    @Column(name = "waktu_pengerjaan",nullable = false)
    private int waktuPengerjaan;

    public Setting() {
        jumlahSoalTampil=50;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getJumlahSoalTampil() {
        return jumlahSoalTampil;
    }

    public void setJumlahSoalTampil(int jumlahSoalTampil) {
        this.jumlahSoalTampil = jumlahSoalTampil;
    }

    public int getWaktuPengerjaan() {
        return waktuPengerjaan;
    }

    public void setWaktuPengerjaan(int waktuPengerjaan) {
        this.waktuPengerjaan = waktuPengerjaan;
    }
}
