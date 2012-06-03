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

    @OneToMany
    @JoinTable(
            name = "soal_list",
            joinColumns = {@JoinColumn(table = "ujian",name = "ujian_id")},
            inverseJoinColumns = {@JoinColumn(table = "soal",name = "soal_id")}
    )
    private List<Soal> listSoal;

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

    public List<Soal> getListSoal() {
        return listSoal;
    }

    public void setListSoal(List<Soal> listSoal) {
        this.listSoal = listSoal;
    }

    public Float getHasil() {
        return hasil;
    }

    public void setHasil(Float hasil) {
        this.hasil = hasil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ujian ujian = (Ujian) o;

        if (calonMahasiswa != null ? !calonMahasiswa.equals(ujian.calonMahasiswa) : ujian.calonMahasiswa != null)
            return false;
        if (hasil != null ? !hasil.equals(ujian.hasil) : ujian.hasil != null) return false;
        if (id != null ? !id.equals(ujian.id) : ujian.id != null) return false;
        if (listSoal != null ? !listSoal.equals(ujian.listSoal) : ujian.listSoal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (calonMahasiswa != null ? calonMahasiswa.hashCode() : 0);
        result = 31 * result + (listSoal != null ? listSoal.hashCode() : 0);
        result = 31 * result + (hasil != null ? hasil.hashCode() : 0);
        return result;
    }
}
