package com.bahri.pmb.domain;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/12/12
 * Time: 9:59 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "pengerjaan_soal")
public class PengerjaanSoal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pengerjaan_soal_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "soal_id",nullable = true)
    private Soal soal;
    @ManyToOne
    @JoinColumn(name = "jawaban_id",nullable = true)
    private Jawaban jawaban;

    public PengerjaanSoal() {
    }

    public PengerjaanSoal(Long id, Soal soal, Jawaban jawaban) {
        this.id = id;
        this.soal = soal;
        this.jawaban = jawaban;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Soal getSoal() {
        return soal;
    }

    public void setSoal(Soal soal) {
        this.soal = soal;
    }

    public Jawaban getJawaban() {
        return jawaban;
    }

    public void setJawaban(Jawaban jawaban) {
        this.jawaban = jawaban;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PengerjaanSoal that = (PengerjaanSoal) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (jawaban != null ? !jawaban.equals(that.jawaban) : that.jawaban != null) return false;
        if (soal != null ? !soal.equals(that.soal) : that.soal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (soal != null ? soal.hashCode() : 0);
        result = 31 * result + (jawaban != null ? jawaban.hashCode() : 0);
        return result;
    }
}
