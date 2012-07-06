package com.bahri.pmb.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 3/26/12
 * Time: 2:25 PM
 * To change this template use File | Settings | File Templates.
 */
public final class CalendarUtil {

    /**
     * format dd-MM-yyyy atau d-MM-yyyy atau dd-M-yyyy
     * dd/MM/yyyy atau d/MM/yyyy atau dd/M/yyyy
     */
    public final static String FORMAT_DATE_1 = "\\d{1,2}[-/]\\d{1,2}[-/]\\d{4}";

    public final static String[] BULAN = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

    /**
     * format dd-MM-yyyy hh:mm:ss atau d-MM-yyyy hh:mm:ss atau dd-M-yyyy  hh:mm:ss
     * dd/MM/yyyy hh:mm:ss atau d/MM/yyyy hh:mm:ss atau dd/M/yyyy hh:mm:ss
     */
    public final static String FORMAT_TIME_1 = "\\d{1,2}[-/]\\d{1,2}[-/]\\d{4}\\s+\\d{1,2}[:]\\d{1,2}[:]\\d{1,2}";

    /**
     * dd-MM-yyyy atau dd/MM/yyyy
     *
     * @param date
     * @return
     */
    public static Calendar stringToCalendar(String date) {
        if (date == null || date.trim().isEmpty() || !date.trim().matches(FORMAT_DATE_1)) return null;
        StringTokenizer st = new StringTokenizer(date.trim(), "-/");
        String tanggal = st.hasMoreTokens() ? st.nextToken() : "0";
        String bulan = st.hasMoreTokens() ? st.nextToken() : "0";
        String tahun = st.hasMoreTokens() ? st.nextToken() : "0";
        Calendar calendar = new GregorianCalendar(Integer.valueOf(tahun), Integer.valueOf(bulan) - 1, Integer.valueOf(tanggal));
        return calendar;
    }

    /**
     * dd-MM-yyyy hh:mm:ss
     *
     * @param date
     * @return
     */
    public static Calendar stringToTime(String date) {
        if (date == null || date.trim().isEmpty() || !date.trim().matches(FORMAT_TIME_1)) return null;
        StringTokenizer st = new StringTokenizer(date.trim(), "-/: ");
        String tanggal = st.hasMoreTokens() ? st.nextToken() : "0";
        String bulan = st.hasMoreTokens() ? st.nextToken() : "0";
        String tahun = st.hasMoreTokens() ? st.nextToken() : "0";
        String jam = st.hasMoreTokens() ? st.nextToken() : "0";
        String menit = st.hasMoreTokens() ? st.nextToken() : "0";
        String detik = st.hasMoreTokens() ? st.nextToken() : "0";
        Calendar calendar = new GregorianCalendar(Integer.valueOf(tahun), Integer.valueOf(bulan) - 1, Integer.valueOf(tanggal), Integer.valueOf(jam),
                Integer.valueOf(menit), Integer.valueOf(detik));
        return calendar;
    }

    /**
     * cek format date
     *
     * @param date
     * @param format
     * @return
     */
    public static boolean cekDateFormat(String date, String format) {
        if (date == null || date.trim().isEmpty()) return false;
        return date.matches(format);
    }

    /**
     * Kembalian format dd-MM-yyyy
     *
     * @param calendar
     * @return
     */
    public static String dateToString(Calendar calendar) {
        if (calendar == null) return null;
        return fixLength2Digit(calendar.get(Calendar.DATE)) + "-" +
                (fixLength2Digit(calendar.get(Calendar.MONTH) + 1)) + "-" +
                calendar.get(Calendar.YEAR);
    }

    public static String fixLength2Digit(int i) {
        String temp = "00" + i;
        return temp.substring(temp.length() - 2, temp.length());
    }

    /**
     * Kembalian waktu format dd-MM-yyyy hh:mm:ss
     *
     * @param calendar
     * @return
     */
    public static String timeToString(Calendar calendar) {
        if (calendar == null) return null;
        return dateToString(calendar) + " " + hourToString(calendar);
    }

    /**
     * Kembalian waktu format dd-MM-yyyy hh:mm:ss
     *
     * @param calendar
     * @return
     */
    public static String timeToStringUjian(Calendar calendar,int jam) {
        if (calendar == null) return null;
         String time= fixLength2Digit(calendar.get(Calendar.MONTH)+ 1) + "/" +
                 (fixLength2Digit(calendar.get(Calendar.DATE) )) + "/" +
                 calendar.get(Calendar.YEAR)+" "+fixLength2Digit(calendar.get(Calendar.HOUR)+2) + ":" +
                 calendar.get(Calendar.MINUTE)+" "+(calendar.get(Calendar.AM_PM)==1?"PM":"AM");
        return time;
    }

    /**
     * Kembalian format hh:mm:ss
     *
     * @param calendar
     * @return
     */
    public static String hourToString(Calendar calendar) {
        if (calendar == null) return null;
        return fixLength2Digit(calendar.get(Calendar.HOUR)) + ":" +
                fixLength2Digit(calendar.get(Calendar.MINUTE)) + ":" +
                fixLength2Digit(calendar.get(Calendar.SECOND));
    }
}
