package com.secondstack.flatoutstore.simple.request;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 5/11/12
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class RequestJurnal {
    private Integer month;
    private Integer year;
    private String awalTanggalTransaksi;
    private String akhirTanggalTransaksi;
    private String format;
    private Long depositId;

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAwalTanggalTransaksi() {
        return awalTanggalTransaksi;
    }

    public void setAwalTanggalTransaksi(String awalTanggalTransaksi) {
        this.awalTanggalTransaksi = awalTanggalTransaksi;
    }

    public String getAkhirTanggalTransaksi() {
        return akhirTanggalTransaksi;
    }

    public void setAkhirTanggalTransaksi(String akhirTanggalTransaksi) {
        this.akhirTanggalTransaksi = akhirTanggalTransaksi;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Long getDepositId() {
        return depositId;
    }

    public void setDepositId(Long depositId) {
        this.depositId = depositId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestJurnal that = (RequestJurnal) o;

        if (akhirTanggalTransaksi != null ? !akhirTanggalTransaksi.equals(that.akhirTanggalTransaksi) : that.akhirTanggalTransaksi != null)
            return false;
        if (awalTanggalTransaksi != null ? !awalTanggalTransaksi.equals(that.awalTanggalTransaksi) : that.awalTanggalTransaksi != null)
            return false;
        if (depositId != null ? !depositId.equals(that.depositId) : that.depositId != null) return false;
        if (format != null ? !format.equals(that.format) : that.format != null) return false;
        if (month != null ? !month.equals(that.month) : that.month != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = month != null ? month.hashCode() : 0;
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (awalTanggalTransaksi != null ? awalTanggalTransaksi.hashCode() : 0);
        result = 31 * result + (akhirTanggalTransaksi != null ? akhirTanggalTransaksi.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        result = 31 * result + (depositId != null ? depositId.hashCode() : 0);
        return result;
    }
}
