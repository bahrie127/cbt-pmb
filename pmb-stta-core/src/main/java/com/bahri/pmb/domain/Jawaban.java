package com.bahri.pmb.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 3/27/12
 * Time: 5:39 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "jawaban")
public class Jawaban {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "jawaban_id")
    private Long id;
                                               //,columnDefinition="TEXT"
    @Column(name = "pilihan",nullable = false,columnDefinition="TEXT")
    //@Size(min = 1,max = 255)
    private String pilihan;
                                                 //,columnDefinition="TINYINT(1)"
    @Column(name = "kebenaran",nullable = false,columnDefinition="BOOLEAN")
    private Boolean kebenaran;

    public Jawaban() {
    }

    public Jawaban(Long id, String pilihan, Boolean kebenaran) {
        this.id = id;
        this.pilihan = pilihan;
        this.kebenaran = kebenaran;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPilihan() {
        return pilihan;
    }

    public void setPilihan(String pilihan) {
        this.pilihan = pilihan;
    }

    public Boolean getKebenaran() {
        return kebenaran;
    }

    public void setKebenaran(Boolean kebenaran) {
        this.kebenaran = kebenaran;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jawaban jawaban = (Jawaban) o;

        if (id != null ? !id.equals(jawaban.id) : jawaban.id != null) return false;
        if (kebenaran != null ? !kebenaran.equals(jawaban.kebenaran) : jawaban.kebenaran != null) return false;
        if (pilihan != null ? !pilihan.equals(jawaban.pilihan) : jawaban.pilihan != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pilihan != null ? pilihan.hashCode() : 0);
        result = 31 * result + (kebenaran != null ? kebenaran.hashCode() : 0);
        return result;
    }
}
