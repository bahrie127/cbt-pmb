package com.bahri.pmb.simple;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 7/17/12
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Statistik {
    private String jurusan;
    private Long jumlah;
    private Double verbal;
    private Double numerik;
    private Double logikal;
    private Double gambar;

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public Long getJumlah() {
        return jumlah;
    }

    public void setJumlah(Long jumlah) {
        this.jumlah = jumlah;
    }

    public Double getVerbal() {
        return verbal;
    }

    public void setVerbal(Double verbal) {
        this.verbal = verbal;
    }

    public Double getNumerik() {
        return numerik;
    }

    public void setNumerik(Double numerik) {
        this.numerik = numerik;
    }

    public Double getLogikal() {
        return logikal;
    }

    public void setLogikal(Double logikal) {
        this.logikal = logikal;
    }

    public Double getGambar() {
        return gambar;
    }

    public void setGambar(Double gambar) {
        this.gambar = gambar;
    }
}
