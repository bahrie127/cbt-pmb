package com.bahri.pmb.domain;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 7/12/12
 * Time: 10:44 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "jenis_soal")
public class JenisSoal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "jenis_soal_id")
    private Long id;
    
    @Column(name = "nama",nullable = false,length = 20)
    private String nama;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JenisSoal jenisSoal = (JenisSoal) o;

        if (id != null ? !id.equals(jenisSoal.id) : jenisSoal.id != null) return false;
        if (nama != null ? !nama.equals(jenisSoal.nama) : jenisSoal.nama != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nama != null ? nama.hashCode() : 0);
        return result;
    }
}
