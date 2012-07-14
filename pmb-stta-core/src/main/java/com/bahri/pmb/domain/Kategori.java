package com.bahri.pmb.domain;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 3/27/12
 * Time: 5:30 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "kategori")
public class Kategori {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "kategori_id")
    private Long id;

    @Column(name = "nama",length = 50,nullable = false)
    private String nama;

    @ManyToOne
    @JoinColumn(name = "jenis_soal_id",nullable = false, unique = false)
    private JenisSoal jenisSoal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public JenisSoal getJenisSoal() {
        return jenisSoal;
    }

    public void setJenisSoal(JenisSoal jenisSoal) {
        this.jenisSoal = jenisSoal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kategori kategori = (Kategori) o;

        if (id != null ? !id.equals(kategori.id) : kategori.id != null) return false;
        if (jenisSoal != null ? !jenisSoal.equals(kategori.jenisSoal) : kategori.jenisSoal != null) return false;
        if (nama != null ? !nama.equals(kategori.nama) : kategori.nama != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nama != null ? nama.hashCode() : 0);
        result = 31 * result + (jenisSoal != null ? jenisSoal.hashCode() : 0);
        return result;
    }
}
