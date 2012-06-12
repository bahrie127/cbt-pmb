package com.bahri.pmb.domain;

import javax.persistence.*;
import java.util.List;

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
    @JoinColumn(name = "calon_mahasiswa_",nullable = false)
    private CalonMahasiswa calonMahasiswa;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ujian_id")
    private List<PengerjaanSoal> pengerjaanSoalList;

    @Column(name = "hasil",nullable = true)
    private Float hasil;

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
}
