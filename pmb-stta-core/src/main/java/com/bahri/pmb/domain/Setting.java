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

    @Column(name = "jumlah_soal_sinonim_tampil",nullable = false)
    private int jumlahSoalSinominTampil;
    
    @Column(name = "jumlah_soal_antonim_tampil",nullable = false)
    private int jumlahSoalAntonimTampil;
    
    @Column(name = "jumlah_soal_padanan_tampil",nullable = false)
    private int jumlahSoalPadananTampil;
    
    @Column(name = "jumlah_soal_seri_angka_tampil",nullable = false)
    private int jumlahSoalSeriAngkaTampil;
    
    @Column(name = "jumlah_soal_seri_huruf_tampil",nullable = false)
    private int jumlahSoalSeriHurufTampil;
    
    @Column(name = "jumlah_soal_teknikal_tampil",nullable = false)
    private int jumlahSoalTeknikalTampil;

    @Column(name = "jumlah_soal_logikal_tampil",nullable = false)
    private int jumlahSoalLogikalTampil;
    
    @Column(name = "jumlah_soal_gambar_tampil",nullable = false)
    private int jumlahSoalGambarTampil;

    //dalam jam
    @Column(name = "waktu_pengerjaan_verbal",nullable = false)
    private int waktuPengerjaanVerbal;
    
    @Column(name = "waktu_pengerjaan_numerik",nullable = false)
    private int waktuPengerjaanNumerik;
    
    @Column(name = "waktu_pengerjaan_logikal",nullable = false)
    private int waktuPengerjaanLogikal;
    
    @Column(name = "waktu_pengerjaan_gambar",nullable = false)
    private int waktuPengerjaanGambar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getJumlahSoalSinominTampil() {
        return jumlahSoalSinominTampil;
    }

    public void setJumlahSoalSinominTampil(int jumlahSoalSinominTampil) {
        this.jumlahSoalSinominTampil = jumlahSoalSinominTampil;
    }

    public int getJumlahSoalAntonimTampil() {
        return jumlahSoalAntonimTampil;
    }

    public int getJumlahSoalTeknikalTampil() {
        return jumlahSoalTeknikalTampil;
    }

    public void setJumlahSoalTeknikalTampil(int jumlahSoalTeknikalTampil) {
        this.jumlahSoalTeknikalTampil = jumlahSoalTeknikalTampil;
    }

    public int getJumlahSoalLogikalTampil() {
        return jumlahSoalLogikalTampil;
    }

    public void setJumlahSoalLogikalTampil(int jumlahSoalLogikalTampil) {
        this.jumlahSoalLogikalTampil = jumlahSoalLogikalTampil;
    }

    public int getJumlahSoalGambarTampil() {
        return jumlahSoalGambarTampil;
    }

    public void setJumlahSoalGambarTampil(int jumlahSoalGambarTampil) {
        this.jumlahSoalGambarTampil = jumlahSoalGambarTampil;
    }

    public void setJumlahSoalAntonimTampil(int jumlahSoalAntonimTampil) {
        this.jumlahSoalAntonimTampil = jumlahSoalAntonimTampil;
    }

    public int getJumlahSoalPadananTampil() {
        return jumlahSoalPadananTampil;
    }

    public void setJumlahSoalPadananTampil(int jumlahSoalPadananTampil) {
        this.jumlahSoalPadananTampil = jumlahSoalPadananTampil;
    }

    public int getJumlahSoalSeriAngkaTampil() {
        return jumlahSoalSeriAngkaTampil;
    }

    public void setJumlahSoalSeriAngkaTampil(int jumlahSoalSeriAngkaTampil) {
        this.jumlahSoalSeriAngkaTampil = jumlahSoalSeriAngkaTampil;
    }

    public int getJumlahSoalSeriHurufTampil() {
        return jumlahSoalSeriHurufTampil;
    }

    public void setJumlahSoalSeriHurufTampil(int jumlahSoalSeriHurufTampil) {
        this.jumlahSoalSeriHurufTampil = jumlahSoalSeriHurufTampil;
    }

    public int getWaktuPengerjaanVerbal() {
        return waktuPengerjaanVerbal;
    }

    public void setWaktuPengerjaanVerbal(int waktuPengerjaanVerbal) {
        this.waktuPengerjaanVerbal = waktuPengerjaanVerbal;
    }

    public int getWaktuPengerjaanNumerik() {
        return waktuPengerjaanNumerik;
    }

    public void setWaktuPengerjaanNumerik(int waktuPengerjaanNumerik) {
        this.waktuPengerjaanNumerik = waktuPengerjaanNumerik;
    }

    public int getWaktuPengerjaanLogikal() {
        return waktuPengerjaanLogikal;
    }

    public void setWaktuPengerjaanLogikal(int waktuPengerjaanLogikal) {
        this.waktuPengerjaanLogikal = waktuPengerjaanLogikal;
    }

    public int getWaktuPengerjaanGambar() {
        return waktuPengerjaanGambar;
    }

    public void setWaktuPengerjaanGambar(int waktuPengerjaanGambar) {
        this.waktuPengerjaanGambar = waktuPengerjaanGambar;
    }
}
