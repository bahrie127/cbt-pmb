package com.bahri.pmb.ui.controller;

import com.bahri.pmb.domain.*;
import com.bahri.pmb.service.*;
import com.bahri.pmb.service.editor.PengerjaanSoalEditor;
import com.bahri.pmb.service.editor.UjianEditor;
import com.bahri.pmb.simple.SimpleSoal;
import com.bahri.pmb.util.CalendarUtil;
import com.bahri.pmb.util.ConstantUtils;
import com.bahri.pmb.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/19/12
 * Time: 10:38 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "ujian")
public class UjianController {

    @Autowired
    @Qualifier("ujianService")
    private UjianService ujianService;

    @Autowired
    @Qualifier("soalService")
    private SoalService soalService;

    @Autowired
    @Qualifier("settingService")
    private SettingService settingService;

    @Autowired
    @Qualifier("kategoriService")
    private KategoriService kategoriService;

    @Autowired
    @Qualifier("pengerjaanSoalService")
    private PengerjaanSoalService pengerjaanSoalService;

    @Autowired
    @Qualifier("calonMahasiswaService")
    private CalonMahasiswaService calonMahasiswaService;

    List<Soal> soals;
    List<PengerjaanSoal> pengerjaanSoals;
    Ujian ujian;
    Long noPendaftaran=0L;
    String waktu;
    @RequestMapping(value = "mulai", method = RequestMethod.GET)
    public String ujianMulai(ModelMap modelMap, @RequestParam(value = "noPendaftaran") Long noPendaftaran) {
        if(this.noPendaftaran==0L){
                waktu=CalendarUtil.timeToStringUjian(new GregorianCalendar(),settingService.getSetting().getWaktuPengerjaan());
        }else {
            if(this.noPendaftaran!=noPendaftaran){
                waktu=CalendarUtil.timeToStringUjian(new GregorianCalendar(),settingService.getSetting().getWaktuPengerjaan());
            }
        }
        this.noPendaftaran = noPendaftaran;
        CalonMahasiswa calonMahasiswa = calonMahasiswaService.findCalonMahasiswa(noPendaftaran);

        if (calonMahasiswa != null) {
            CalonMahasiswa cm = new CalonMahasiswa();
            cm.setId(noPendaftaran);
            ujian=new Ujian();
            ujian = ujianService.findUjianByPendaftaran(cm);

            if (ujian == null) {
                ujian = new Ujian();
                ujian.setCalonMahasiswa(cm);
                this.getSoals();
                List<PengerjaanSoal> pengerjaanSoals = new ArrayList<PengerjaanSoal>();
                Jawaban jawaban=new Jawaban();
                jawaban.setId(0L);
                for (int i = 0; i < settingService.getSetting().getJumlahSoalTampil(); i++) {
                    PengerjaanSoal pengerjaanSoal = new PengerjaanSoal();
                    pengerjaanSoal.setSoal(soals.get(i));
                    pengerjaanSoal.setJawaban(jawaban);
                    pengerjaanSoals.add(pengerjaanSoal);
                }

                ujian.setPengerjaanSoalList(pengerjaanSoals);

                ujianService.save(ujian);

                this.pengerjaanSoals=pengerjaanSoals;

            }else {
                pengerjaanSoals=ujianService.findPengerjaanSoalByPendaftaran(cm);
            }

            modelMap.addAttribute("namaPeserta", calonMahasiswa.getNama());
            modelMap.addAttribute("tanggal", CalendarUtil.dateToString(new GregorianCalendar()));
            modelMap.addAttribute("ujian", ConstantUtils.tampilkanDiPanelPengerjaanSoal(pengerjaanSoals, ConstantUtils.PAGE_RECORD_SOAL, 1));
            modelMap.addAttribute("nomor", "0");
            modelMap.addAttribute("url", "/cbt-pmb/ujian");
            modelMap.addAttribute("url_hasil", "/cbt-pmb/ujian/hasil");
            modelMap.addAttribute("waktu", waktu);
            modelMap.addAttribute("countPage", (int) Math.ceil((double) pengerjaanSoals.size() / (double) ConstantUtils.PAGE_RECORD_SOAL));
            return "cbt-page";
        } else {
            modelMap.addAttribute("param", "gagal");
            return "login-peserta";
        }
    }

    public void getSoals() {
        soals=new ArrayList<Soal>();
        int jumlahSoal = settingService.getSetting().getJumlahSoalTampil();
        int jumlahKategori = Integer.parseInt(kategoriService.countKategoris() + "");
        int soalPerkategori = (int) Math.floor((double) jumlahSoal / (double) jumlahKategori);

        for (int i = 1; i <= jumlahKategori; i++) {
            List<Soal> soalByKategori = soalService.findSoalsByKategori(Long.parseLong(i + ""), soalPerkategori);
            for (Soal soal : soalByKategori) {
                soals.add(soal);
                soal.setView((soal.getView() == null ? 0 : soal.getView()) + 1);
                soalService.save(soal);
            }
        }

        int jumlahSoalSetelahKategori = soals.size();
        if (jumlahSoal > jumlahSoalSetelahKategori) {
            int kurangSoal = jumlahSoal - jumlahSoalSetelahKategori;
            List<Soal> soalKurang = soalService.findSoalsKurang(kurangSoal);
            for (Soal soal : soalKurang) {
                soals.add(soal);
                soal.setView((soal.getView() == null ? 0 : soal.getView()) + 1);
                soalService.save(soal);
            }
        }

        soals=setRandomSoal(soals);

        for(Soal soal:soals){
            soal.setJawabans(setRandomJawaban(soal.getJawabans()));
        }


    }

    public List<Soal> setRandomSoal(List<Soal> soalSebelumRandoms) {
        List<Soal> listAcak = new ArrayList<Soal>();
        Soal sb = new Soal();
        for (int i = 0; i < soalSebelumRandoms.size(); i++) {
            listAcak.add(sb);
        }
        boolean ulang = false;
        int n = 0, m = 0;
        do {
            ulang = false;
            n = RandomUtil.nextRandom(soalSebelumRandoms.size());
            for (int c = 0; c < soalSebelumRandoms.size(); c++) {
                if (soalSebelumRandoms.get(n).getId() == listAcak.get(c).getId()) {
                    ulang = true;
                    break;
                }

            }
            if (ulang) {
                continue;
            }
            listAcak.set(m, soalSebelumRandoms.get(n));
            m++;
        } while (m < soalSebelumRandoms.size());
        return listAcak;
    }

    public List<Jawaban> setRandomJawaban(List<Jawaban> jawabanSebelumRandoms) {
        List<Jawaban> listAcakJawaban = new ArrayList<Jawaban>();
        Jawaban jawaban=new Jawaban();
        for (int i = 0; i < jawabanSebelumRandoms.size(); i++) {
            listAcakJawaban.add(jawaban);
        }
        boolean ulang = false;
        int n = 0, m = 0;
        do {
            ulang = false;
            n = RandomUtil.nextRandom(jawabanSebelumRandoms.size());
            for (int c = 0; c < jawabanSebelumRandoms.size(); c++) {
                if (jawabanSebelumRandoms.get(n).getId() == listAcakJawaban.get(c).getId()) {
                    ulang = true;
                    break;
                }

            }
            if (ulang) {
                continue;
            }
            listAcakJawaban.set(m, jawabanSebelumRandoms.get(n));
            m++;
        } while (m < jawabanSebelumRandoms.size());
        return listAcakJawaban;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String find(ModelMap modelMap, @RequestParam(value = "page", defaultValue = "1") int page) {
        CalonMahasiswa cm = new CalonMahasiswa();
        cm.setId(noPendaftaran);

        ujian = ujianService.findUjianByPendaftaran(cm);

        pengerjaanSoals=ujianService.findPengerjaanSoalByPendaftaran(cm);
        modelMap.addAttribute("ujian", ConstantUtils.tampilkanDiPanelPengerjaanSoal(pengerjaanSoals, ConstantUtils.PAGE_RECORD_SOAL, page));
        modelMap.addAttribute("nomor", ((page - 1) * ConstantUtils.PAGE_RECORD_SOAL) + "");
        modelMap.addAttribute("url", "/cbt-pmb/ujian");
        return "cbt/page";
    }

    @RequestMapping(value = "jawab", method = RequestMethod.GET)
    public void jawab(@RequestParam(value = "calonMahasiswaId") Long calonMahasiswaId,
                      @RequestParam(value = "ujianId") Long ujianId,
                      @RequestParam(value = "pengerjaanSoalId") Long pengerjaanSoalId,
                      @RequestParam(value = "soalId") Long soalId,
                      @RequestParam(value = "jawabanId") Long jawabanId) {

        PengerjaanSoal pengerjaanSoal = new PengerjaanSoal();
        pengerjaanSoal.setId(pengerjaanSoalId);
        Soal soal = new Soal();
        soal.setId(soalId);
        Jawaban jawaban = new Jawaban();
        jawaban.setId(jawabanId);
        pengerjaanSoal.setSoal(soal);
        pengerjaanSoal.setJawaban(jawaban);

        pengerjaanSoalService.save(pengerjaanSoal);

    }

    @RequestMapping(value = "hasil", method = RequestMethod.GET)
    public String hasil(ModelMap modelMap) {

        CalonMahasiswa cm = new CalonMahasiswa();
        cm.setId(noPendaftaran);

        ujian = ujianService.findUjianByPendaftaran(cm);

        int benar = 0;

        for (PengerjaanSoal pengerjaanSoal : ujian.getPengerjaanSoalList()) {
            if (pengerjaanSoal.getJawaban() != null && pengerjaanSoal.getJawaban().getKebenaran()) {
                benar++;
            }
        }
        float hasil = ((float) benar / ujian.getPengerjaanSoalList().size()) * (float) 100;
        ujian.setHasil(hasil);

        ujianService.save(ujian);
        modelMap.addAttribute("hasil", hasil);
        return "cbt/hasil";

    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(Ujian.class, new UjianEditor(ujianService));
        binder.registerCustomEditor(PengerjaanSoal.class, new PengerjaanSoalEditor(pengerjaanSoalService));
    }
}
