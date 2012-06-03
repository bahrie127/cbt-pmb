package com.bahri.pmb.domain;

import com.bahri.pmb.domain.enumeration.EnumJawaban;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 3/27/12
 * Time: 5:32 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "soal")
public class Soal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "soal_id")
    private Long id;

    @Column(name = "pertanyaan",nullable = false)
    private String pertanyaan;

    @ManyToOne
    @JoinColumn(name = "kategori_",nullable = false)
    private Kategori kategori;

    @Column(name = "is_view",nullable = true)
    private Long isView;

    @OneToMany
    @JoinTable(
            name = "jawaban_map",
            joinColumns = {@JoinColumn(name = "soal_")},
            inverseJoinColumns = {@JoinColumn(table = "jawaban", name = "jawaban_id")}
    )
    private Map<EnumJawaban, Jawaban> jawabanMap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public Long getView() {
        return isView;
    }

    public void setView(Long view) {
        isView = view;
    }

    public Map<EnumJawaban, Jawaban> getJawabanMap() {
        return jawabanMap;
    }

    public void setJawabanMap(Map<EnumJawaban, Jawaban> jawabanMap) {
        this.jawabanMap = jawabanMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Soal soal = (Soal) o;

        if (id != null ? !id.equals(soal.id) : soal.id != null) return false;
        if (isView != null ? !isView.equals(soal.isView) : soal.isView != null) return false;
        if (jawabanMap != null ? !jawabanMap.equals(soal.jawabanMap) : soal.jawabanMap != null) return false;
        if (kategori != null ? !kategori.equals(soal.kategori) : soal.kategori != null) return false;
        if (pertanyaan != null ? !pertanyaan.equals(soal.pertanyaan) : soal.pertanyaan != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pertanyaan != null ? pertanyaan.hashCode() : 0);
        result = 31 * result + (kategori != null ? kategori.hashCode() : 0);
        result = 31 * result + (isView != null ? isView.hashCode() : 0);
        result = 31 * result + (jawabanMap != null ? jawabanMap.hashCode() : 0);
        return result;
    }
}
