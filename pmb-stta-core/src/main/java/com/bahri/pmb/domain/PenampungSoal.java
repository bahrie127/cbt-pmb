package com.bahri.pmb.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 7/2/12
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "penampung_soal_ujian")
public class PenampungSoal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "penampung_soal_ujian_id")
    private Long id;

    @Column(name = "ujian_id")
    private Long idUjian;

    @ManyToMany
    @JoinTable(
            name = "soal_penampung_list",
            joinColumns = {@JoinColumn(name = "penampung_soal_ujian_id")},
            inverseJoinColumns = {@JoinColumn(table = "soal", name = "soal_id")}
    )
    @LazyCollection(value = LazyCollectionOption.FALSE)
    private List<Soal> soalList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUjian() {
        return idUjian;
    }

    public void setIdUjian(Long idUjian) {
        this.idUjian = idUjian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PenampungSoal that = (PenampungSoal) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idUjian != null ? !idUjian.equals(that.idUjian) : that.idUjian != null) return false;
        if (soalList != null ? !soalList.equals(that.soalList) : that.soalList != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idUjian != null ? idUjian.hashCode() : 0);
        result = 31 * result + (soalList != null ? soalList.hashCode() : 0);
        return result;
    }

    public List<Soal> getSoalList() {

        return soalList;
    }

    public void setSoalList(List<Soal> soalList) {
        this.soalList = soalList;
    }
}
