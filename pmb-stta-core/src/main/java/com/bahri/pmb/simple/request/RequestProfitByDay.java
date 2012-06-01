package com.secondstack.flatoutstore.simple.request;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 5/14/12
 * Time: 11:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class RequestProfitByDay {

    private String awal;
    private String akhir;
    private String format;

    public String getAwal() {
        return awal;
    }

    public void setAwal(String awal) {
        this.awal = awal;
    }

    public String getAkhir() {
        return akhir;
    }

    public void setAkhir(String akhir) {
        this.akhir = akhir;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestProfitByDay that = (RequestProfitByDay) o;

        if (akhir != null ? !akhir.equals(that.akhir) : that.akhir != null) return false;
        if (awal != null ? !awal.equals(that.awal) : that.awal != null) return false;
        if (format != null ? !format.equals(that.format) : that.format != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = awal != null ? awal.hashCode() : 0;
        result = 31 * result + (akhir != null ? akhir.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        return result;
    }
}
