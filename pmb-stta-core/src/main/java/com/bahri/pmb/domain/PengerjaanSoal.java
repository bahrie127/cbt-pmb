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
    @JoinColumn(name = "soal_id",nullable = false)
    private Soal soal;
    @ManyToOne
    @JoinColumn(name = "jawaban_id",nullable = false)
    private Jawaban jawaban;

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
}
