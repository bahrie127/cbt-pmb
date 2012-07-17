package com.bahri.pmb.util;

import com.bahri.pmb.domain.PengerjaanSoal;
import com.bahri.pmb.simple.SimpleSoal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: latief
 * Date: 3/29/12
 * Time: 8:36 PM
 * To change this template use File | Settings | File Templates.
 */
public final class ConstantUtils {

    /**
     * kunci untuk jumlah maksimal semua record, jika query tanpa limit / pagination - select all -
     */
    public final static String KEY_COUNT_RECORDS = "count_records";
    /**
     * kunci untuk jumlah maksimal result tiap halaman/page
     */
    public final static String KEY_MAX_RESULTS = "max_results";
    /**
     * kunci untuk jumlah record yang didapat dari sebuah query
     */
    public final static String KEY_COUNT_RESULTS = "count_results";
    /**
     * kunci untuk awal record keberapa pada halaman/page tersebut
     */
    public final static String KEY_FIRST_RESULT = "first_result";
    /**
     * kunci untuk akhir record keberapa pada halaman/page tersebut
     */
    public final static String KEY_LAST_RESULT = "last_result";
    /**
     * kunci untuk jumlah semua halaman yang bisa didapat
     */
    public final static String KEY_COUNT_PAGES = "count_pages";
    /**
     * kunci untuk halaman sekarang
     */
    public final static String KEY_CURRENT_PAGE = "current_page";
    /**
     * kunci untuk hasil dari query
     */
    public final static String KEY_RESULTS = "results";

    /**
     * Id default untuk kategori pembelian
     */
    public final static Long ID_KATEGORI_PEMBELIAN = 1l;
    /**
     * Id default untuk kategori penjualan
     */
    public final static Long ID_KATEGORI_PENJUALAN = 2l;
    /**
     * Id default untuk kategori ongkos kirim untuk tipe debit
     */
    public final static Long ID_KATEGORI_ONGKOS_KIRIM_DEBIT = 3l;
    /**
     * Id default untuk kategori ongkos kirim untuk tipe kredit
     */
    public final static Long ID_KATEGORI_ONGKOS_KIRIM_KREDIT = 4l;

    /**
     * max pagination record
     */
    public final static int PAGE_MAX_RECORD = 20;

    /**
     * max pagination record soal
     */
    public final static int PAGE_RECORD_SOAL = 10;

    /**
     * max left pagination
     */
    public final static int MAX_LEFT_PAGINATION = 4;
    /**
     * max right pagination
     */
    public final static int MAX_RIGHT_PAGINATION = 5;

    /**
     * mencari nilai paling kanan dan paling kiri
     * array 0 kiri
     * arry 1 kanan
     * @param page
     * @param countPage
     * @return
     */
    public static int[] leftRightPagination(int page, int countPage) {
        int kanan = MAX_RIGHT_PAGINATION;
        int kiri = MAX_LEFT_PAGINATION;
        if ((page - MAX_LEFT_PAGINATION) <= 0) {
            kiri = page - 1;
            kanan = kanan + (MAX_LEFT_PAGINATION - kiri);
        }

        if ((page + kanan) > countPage) {
            kanan = countPage - page;
            if ((page - MAX_LEFT_PAGINATION) > 1) {
                kiri = kiri + (MAX_RIGHT_PAGINATION - kanan);
            }
        }
        int[] pagination = new int[2];
        pagination[0] = kiri;
        pagination[1] = kanan;

        return pagination;
    }

    public static List<SimpleSoal> tampilkanDiPanelSoal(List<SimpleSoal> soals,int soalPerHalaman,int page){
        List<SimpleSoal> returnSoal;
        returnSoal=soals.subList(((page-1)*soalPerHalaman),(soalPerHalaman*page));
        return returnSoal;
    }

    public static List<PengerjaanSoal> tampilkanDiPanelPengerjaanSoal(List<PengerjaanSoal> pengerjaanSoals,int from,int to){
        List<PengerjaanSoal> returnPengerjaanSoal;
        returnPengerjaanSoal=pengerjaanSoals.subList(from,to);
        return returnPengerjaanSoal;
    }
}
