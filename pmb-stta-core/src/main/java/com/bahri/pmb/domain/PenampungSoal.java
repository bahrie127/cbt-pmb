package com.bahri.pmb.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany
    @JoinTable(
            name = "soal_ujian_list",
            joinColumns = {@JoinColumn(table = "soal",name = "soal_id")},
            inverseJoinColumns = {@JoinColumn(table = "penampung_soal_ujian",name = "penampung_soal_ujian_id")}
    )
    @LazyCollection(value = LazyCollectionOption.TRUE)
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

    public List<Soal> getSoalList() {
        return soalList;
    }

    public void setSoalList(List<Soal> soalList) {
        this.soalList = soalList;
    }
}
