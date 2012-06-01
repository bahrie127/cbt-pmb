package com.secondstack.flatoutstore.simple.request;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 5/14/12
 * Time: 11:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class RequestProfitByMonth {
    private Integer firstMonth;
    private Integer firstYear;
    private Integer lastMonth;
    private Integer lastYear;
    private String format;

    public Integer getFirstMonth() {
        return firstMonth;
    }

    public void setFirstMonth(Integer firstMonth) {
        this.firstMonth = firstMonth;
    }

    public Integer getFirstYear() {
        return firstYear;
    }

    public void setFirstYear(Integer firstYear) {
        this.firstYear = firstYear;
    }

    public Integer getLastMonth() {
        return lastMonth;
    }

    public void setLastMonth(Integer lastMonth) {
        this.lastMonth = lastMonth;
    }

    public Integer getLastYear() {
        return lastYear;
    }

    public void setLastYear(Integer lastYear) {
        this.lastYear = lastYear;
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

        RequestProfitByMonth that = (RequestProfitByMonth) o;

        if (firstMonth != null ? !firstMonth.equals(that.firstMonth) : that.firstMonth != null) return false;
        if (firstYear != null ? !firstYear.equals(that.firstYear) : that.firstYear != null) return false;
        if (format != null ? !format.equals(that.format) : that.format != null) return false;
        if (lastMonth != null ? !lastMonth.equals(that.lastMonth) : that.lastMonth != null) return false;
        if (lastYear != null ? !lastYear.equals(that.lastYear) : that.lastYear != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstMonth != null ? firstMonth.hashCode() : 0;
        result = 31 * result + (firstYear != null ? firstYear.hashCode() : 0);
        result = 31 * result + (lastMonth != null ? lastMonth.hashCode() : 0);
        result = 31 * result + (lastYear != null ? lastYear.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        return result;
    }
}
