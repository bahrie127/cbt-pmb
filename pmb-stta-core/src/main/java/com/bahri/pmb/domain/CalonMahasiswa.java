package com.bahri.pmb.domain;

import com.bahri.pmb.domain.enumeration.JenisKelamin;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 3/27/12
 * Time: 5:42 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "calon_mahasiswa")
public class CalonMahasiswa {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "calon_mahasiswa_id")
    private Long id;

    @Column(name = "nama",length = 30,nullable = false)
    private String nama;

    @Column(name = "tempat_lahir",length = 100,nullable = false)
    private String tempatLahir;

    @Column(name = "tanggal_lahir",length = 244,nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Calendar tanggalLahir;

    @Column(name = "jenis_kelamin",nullable = false)
    private JenisKelamin jenisKelamin;

    @Column(name = "agama",nullable = false,length = 25)
    private String agama;
    
    @Column(name = "slta",nullable = false,length = 100)
    private String slta;
    
    @Column(name = "jurusan",nullable = false,length = 15)
    private String jurusan;
    
    @Column(name = "nama_sekolah",nullable = false,length = 100)
    private String namaSekolah;
    
    @Column(name = "alamat_sekolah",nullable = false,length = 100)
    private String alamatSekolah;
    
    @Column(name = "kabupaten",nullable = false,length = 100)
    private String kabupaten;
    
    @Column(name = "kode_pos_sekolah",nullable = false,length = 10)
    private String kodePosSekolah;
    
    @Column(name = "propinsi_sekolah",nullable = false,length = 30)
    private String propinsiSekolah;

    @Column(name = "pilihanpertama",nullable = false,length = 50)
    private String pilihanPertama;
    
    @Column(name = "pilihankedua",nullable = false,length = 50)
    private String pilihanKedua;

    @Column(name = "alamat_tes",nullable = true,length = 100)
    private String alamatTes;
    
    @Column(name = "kabupaten_tes",nullable = true,length = 100)
    private String kabupatenTes;

    @Column(name = "kode_pos_tes",nullable = true,length = 10)
    private String kodePosTes;
    
    @Column(name = "propinsi_tes",nullable = true,length = 100)
    private String propinsiTes;

    @Column(name = "telephone_tes",nullable = true,length = 20)
    private String telephoneTes;
    
    @Column(name = "handphone_tes",nullable = true,length = 20)
    private String handphoneTes;

    @Column(name = "email_tes",nullable = true,length = 50)
    private String emailTes;

    @Column(name = "info_stta",nullable = true,length = 100)
    private String infoStta;

    @Column(name = "nama_ortu",nullable = false,length = 100)
    private String namaOrtu;

    @Column(name = "alamat_ortu",nullable = false,length = 100)
    private String alamatOrtu;

    @Column(name = "kabupaten_ortu",nullable = false,length = 100)
    private String kabupatenOrtu;

    @Column(name = "kode_pos_ortu",nullable = false,length = 100)
    private String kodePosOrtu;

    @Column(name = "propinsi_ortu",nullable = false,length = 100)
    private String propinsiOrtu;

    @Column(name = "telephone_ortu",nullable = true,length = 20)
    private String telehoneOrtu;

    @Column(name = "handphone_ortu",nullable = true,length = 20)
    private String handphoneOrtu;

    @Column(name = "pekerjaan_ortu",nullable = false,length = 100)
    private String pekerjaanOrtu;

    @Column(name = "tgl_registrasi",nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Calendar tglRegistrasi;

    @Column(name = "sumbangan",nullable = false,length = 10)
    private String sumbangan;

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

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Calendar getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Calendar tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public JenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(JenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getSlta() {
        return slta;
    }

    public void setSlta(String slta) {
        this.slta = slta;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getNamaSekolah() {
        return namaSekolah;
    }

    public void setNamaSekolah(String namaSekolah) {
        this.namaSekolah = namaSekolah;
    }

    public String getAlamatSekolah() {
        return alamatSekolah;
    }

    public void setAlamatSekolah(String alamatSekolah) {
        this.alamatSekolah = alamatSekolah;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getKodePosSekolah() {
        return kodePosSekolah;
    }

    public void setKodePosSekolah(String kodePosSekolah) {
        this.kodePosSekolah = kodePosSekolah;
    }

    public String getPropinsiSekolah() {
        return propinsiSekolah;
    }

    public void setPropinsiSekolah(String propinsiSekolah) {
        this.propinsiSekolah = propinsiSekolah;
    }

    public String getPilihanPertama() {
        return pilihanPertama;
    }

    public void setPilihanPertama(String pilihanPertama) {
        this.pilihanPertama = pilihanPertama;
    }

    public String getPilihanKedua() {
        return pilihanKedua;
    }

    public void setPilihanKedua(String pilihanKedua) {
        this.pilihanKedua = pilihanKedua;
    }

    public String getAlamatTes() {
        return alamatTes;
    }

    public void setAlamatTes(String alamatTes) {
        this.alamatTes = alamatTes;
    }

    public String getKabupatenTes() {
        return kabupatenTes;
    }

    public void setKabupatenTes(String kabupatenTes) {
        this.kabupatenTes = kabupatenTes;
    }

    public String getKodePosTes() {
        return kodePosTes;
    }

    public void setKodePosTes(String kodePosTes) {
        this.kodePosTes = kodePosTes;
    }

    public String getPropinsiTes() {
        return propinsiTes;
    }

    public void setPropinsiTes(String propinsiTes) {
        this.propinsiTes = propinsiTes;
    }

    public String getTelephoneTes() {
        return telephoneTes;
    }

    public void setTelephoneTes(String telephoneTes) {
        this.telephoneTes = telephoneTes;
    }

    public String getHandphoneTes() {
        return handphoneTes;
    }

    public void setHandphoneTes(String handphoneTes) {
        this.handphoneTes = handphoneTes;
    }

    public String getEmailTes() {
        return emailTes;
    }

    public void setEmailTes(String emailTes) {
        this.emailTes = emailTes;
    }

    public String getInfoStta() {
        return infoStta;
    }

    public void setInfoStta(String infoStta) {
        this.infoStta = infoStta;
    }

    public String getNamaOrtu() {
        return namaOrtu;
    }

    public void setNamaOrtu(String namaOrtu) {
        this.namaOrtu = namaOrtu;
    }

    public String getAlamatOrtu() {
        return alamatOrtu;
    }

    public void setAlamatOrtu(String alamatOrtu) {
        this.alamatOrtu = alamatOrtu;
    }

    public String getKabupatenOrtu() {
        return kabupatenOrtu;
    }

    public void setKabupatenOrtu(String kabupatenOrtu) {
        this.kabupatenOrtu = kabupatenOrtu;
    }

    public String getKodePosOrtu() {
        return kodePosOrtu;
    }

    public void setKodePosOrtu(String kodePosOrtu) {
        this.kodePosOrtu = kodePosOrtu;
    }

    public String getPropinsiOrtu() {
        return propinsiOrtu;
    }

    public void setPropinsiOrtu(String propinsiOrtu) {
        this.propinsiOrtu = propinsiOrtu;
    }

    public String getTelehoneOrtu() {
        return telehoneOrtu;
    }

    public void setTelehoneOrtu(String telehoneOrtu) {
        this.telehoneOrtu = telehoneOrtu;
    }

    public String getHandphoneOrtu() {
        return handphoneOrtu;
    }

    public void setHandphoneOrtu(String handphoneOrtu) {
        this.handphoneOrtu = handphoneOrtu;
    }

    public String getPekerjaanOrtu() {
        return pekerjaanOrtu;
    }

    public void setPekerjaanOrtu(String pekerjaanOrtu) {
        this.pekerjaanOrtu = pekerjaanOrtu;
    }

    public Calendar getTglRegistrasi() {
        return tglRegistrasi;
    }

    public void setTglRegistrasi(Calendar tglRegistrasi) {
        this.tglRegistrasi = tglRegistrasi;
    }

    public String getSumbangan() {
        return sumbangan;
    }

    public void setSumbangan(String sumbangan) {
        this.sumbangan = sumbangan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalonMahasiswa that = (CalonMahasiswa) o;

        if (agama != null ? !agama.equals(that.agama) : that.agama != null) return false;
        if (alamatOrtu != null ? !alamatOrtu.equals(that.alamatOrtu) : that.alamatOrtu != null) return false;
        if (alamatSekolah != null ? !alamatSekolah.equals(that.alamatSekolah) : that.alamatSekolah != null)
            return false;
        if (alamatTes != null ? !alamatTes.equals(that.alamatTes) : that.alamatTes != null) return false;
        if (emailTes != null ? !emailTes.equals(that.emailTes) : that.emailTes != null) return false;
        if (handphoneOrtu != null ? !handphoneOrtu.equals(that.handphoneOrtu) : that.handphoneOrtu != null)
            return false;
        if (handphoneTes != null ? !handphoneTes.equals(that.handphoneTes) : that.handphoneTes != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (infoStta != null ? !infoStta.equals(that.infoStta) : that.infoStta != null) return false;
        if (jenisKelamin != that.jenisKelamin) return false;
        if (jurusan != null ? !jurusan.equals(that.jurusan) : that.jurusan != null) return false;
        if (kabupaten != null ? !kabupaten.equals(that.kabupaten) : that.kabupaten != null) return false;
        if (kabupatenOrtu != null ? !kabupatenOrtu.equals(that.kabupatenOrtu) : that.kabupatenOrtu != null)
            return false;
        if (kabupatenTes != null ? !kabupatenTes.equals(that.kabupatenTes) : that.kabupatenTes != null) return false;
        if (kodePosOrtu != null ? !kodePosOrtu.equals(that.kodePosOrtu) : that.kodePosOrtu != null) return false;
        if (kodePosSekolah != null ? !kodePosSekolah.equals(that.kodePosSekolah) : that.kodePosSekolah != null)
            return false;
        if (kodePosTes != null ? !kodePosTes.equals(that.kodePosTes) : that.kodePosTes != null) return false;
        if (nama != null ? !nama.equals(that.nama) : that.nama != null) return false;
        if (namaOrtu != null ? !namaOrtu.equals(that.namaOrtu) : that.namaOrtu != null) return false;
        if (namaSekolah != null ? !namaSekolah.equals(that.namaSekolah) : that.namaSekolah != null) return false;
        if (pekerjaanOrtu != null ? !pekerjaanOrtu.equals(that.pekerjaanOrtu) : that.pekerjaanOrtu != null)
            return false;
        if (pilihanKedua != null ? !pilihanKedua.equals(that.pilihanKedua) : that.pilihanKedua != null) return false;
        if (pilihanPertama != null ? !pilihanPertama.equals(that.pilihanPertama) : that.pilihanPertama != null)
            return false;
        if (propinsiOrtu != null ? !propinsiOrtu.equals(that.propinsiOrtu) : that.propinsiOrtu != null) return false;
        if (propinsiSekolah != null ? !propinsiSekolah.equals(that.propinsiSekolah) : that.propinsiSekolah != null)
            return false;
        if (propinsiTes != null ? !propinsiTes.equals(that.propinsiTes) : that.propinsiTes != null) return false;
        if (slta != null ? !slta.equals(that.slta) : that.slta != null) return false;
        if (sumbangan != null ? !sumbangan.equals(that.sumbangan) : that.sumbangan != null) return false;
        if (tanggalLahir != null ? !tanggalLahir.equals(that.tanggalLahir) : that.tanggalLahir != null) return false;
        if (telehoneOrtu != null ? !telehoneOrtu.equals(that.telehoneOrtu) : that.telehoneOrtu != null) return false;
        if (telephoneTes != null ? !telephoneTes.equals(that.telephoneTes) : that.telephoneTes != null) return false;
        if (tempatLahir != null ? !tempatLahir.equals(that.tempatLahir) : that.tempatLahir != null) return false;
        if (tglRegistrasi != null ? !tglRegistrasi.equals(that.tglRegistrasi) : that.tglRegistrasi != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nama != null ? nama.hashCode() : 0);
        result = 31 * result + (tempatLahir != null ? tempatLahir.hashCode() : 0);
        result = 31 * result + (tanggalLahir != null ? tanggalLahir.hashCode() : 0);
        result = 31 * result + (jenisKelamin != null ? jenisKelamin.hashCode() : 0);
        result = 31 * result + (agama != null ? agama.hashCode() : 0);
        result = 31 * result + (slta != null ? slta.hashCode() : 0);
        result = 31 * result + (jurusan != null ? jurusan.hashCode() : 0);
        result = 31 * result + (namaSekolah != null ? namaSekolah.hashCode() : 0);
        result = 31 * result + (alamatSekolah != null ? alamatSekolah.hashCode() : 0);
        result = 31 * result + (kabupaten != null ? kabupaten.hashCode() : 0);
        result = 31 * result + (kodePosSekolah != null ? kodePosSekolah.hashCode() : 0);
        result = 31 * result + (propinsiSekolah != null ? propinsiSekolah.hashCode() : 0);
        result = 31 * result + (pilihanPertama != null ? pilihanPertama.hashCode() : 0);
        result = 31 * result + (pilihanKedua != null ? pilihanKedua.hashCode() : 0);
        result = 31 * result + (alamatTes != null ? alamatTes.hashCode() : 0);
        result = 31 * result + (kabupatenTes != null ? kabupatenTes.hashCode() : 0);
        result = 31 * result + (kodePosTes != null ? kodePosTes.hashCode() : 0);
        result = 31 * result + (propinsiTes != null ? propinsiTes.hashCode() : 0);
        result = 31 * result + (telephoneTes != null ? telephoneTes.hashCode() : 0);
        result = 31 * result + (handphoneTes != null ? handphoneTes.hashCode() : 0);
        result = 31 * result + (emailTes != null ? emailTes.hashCode() : 0);
        result = 31 * result + (infoStta != null ? infoStta.hashCode() : 0);
        result = 31 * result + (namaOrtu != null ? namaOrtu.hashCode() : 0);
        result = 31 * result + (alamatOrtu != null ? alamatOrtu.hashCode() : 0);
        result = 31 * result + (kabupatenOrtu != null ? kabupatenOrtu.hashCode() : 0);
        result = 31 * result + (kodePosOrtu != null ? kodePosOrtu.hashCode() : 0);
        result = 31 * result + (propinsiOrtu != null ? propinsiOrtu.hashCode() : 0);
        result = 31 * result + (telehoneOrtu != null ? telehoneOrtu.hashCode() : 0);
        result = 31 * result + (handphoneOrtu != null ? handphoneOrtu.hashCode() : 0);
        result = 31 * result + (pekerjaanOrtu != null ? pekerjaanOrtu.hashCode() : 0);
        result = 31 * result + (tglRegistrasi != null ? tglRegistrasi.hashCode() : 0);
        result = 31 * result + (sumbangan != null ? sumbangan.hashCode() : 0);
        return result;
    }
}
