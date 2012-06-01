package com.bahri.pmb.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 3/12/12
 * Time: 2:11 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="distributor")
public class Distributor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "distributor_id")
    private Long id;

    @Column(name = "nama",nullable = false)
    @Size(min = 1, max = 100)
    private String nama;

    @Column(name = "alamat",nullable = false)
    @Size(min = 1, max = 255)
    private String alamat;

    @Column(name = "phone1",length = 20,nullable = true)
    private String phone1;

    @Column(name = "phone2",length = 20,nullable = true)
    private String phone2;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "web",nullable = false)
    private String web;

    public Distributor() {
    }

    public Distributor(Long id, String nama, String alamat, String phone1, String phone2, String email, String web) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        this.web = web;
    }

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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Distributor)) return false;

        Distributor that = (Distributor) o;

        if (alamat != null ? !alamat.equals(that.alamat) : that.alamat != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nama != null ? !nama.equals(that.nama) : that.nama != null) return false;
        if (phone1 != null ? !phone1.equals(that.phone1) : that.phone1 != null) return false;
        if (phone2 != null ? !phone2.equals(that.phone2) : that.phone2 != null) return false;
        if (web != null ? !web.equals(that.web) : that.web != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nama != null ? nama.hashCode() : 0);
        result = 31 * result + (alamat != null ? alamat.hashCode() : 0);
        result = 31 * result + (phone1 != null ? phone1.hashCode() : 0);
        result = 31 * result + (phone2 != null ? phone2.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (web != null ? web.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return this.nama;
    }
}
