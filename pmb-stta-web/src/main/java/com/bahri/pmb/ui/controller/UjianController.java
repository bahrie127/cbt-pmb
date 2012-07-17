package com.bahri.pmb.ui.controller;

import com.bahri.pmb.domain.*;
import com.bahri.pmb.service.*;
import com.bahri.pmb.service.editor.PengerjaanSoalEditor;
import com.bahri.pmb.service.editor.UjianEditor;
import com.bahri.pmb.util.CalendarUtil;
import com.bahri.pmb.util.ConstantUtils;
import com.bahri.pmb.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
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

    List<Soal> allSoals;

    List<Soal> soalVerbals;
    List<Soal> soalNumeriks;
    List<Soal> soalLogikals;
    List<Soal> soalGambars;
    List<PengerjaanSoal> pengerjaanSoals;
    Ujian ujian;
    Long noPendaftaran = 0L;
    String waktu;
    String waktuPengerjaanVerbal;
    String waktuPengerjaanNumerik;
    String waktuPengerjaanLogikal;
    String waktuPengerjaanGambar;

    int soalVerbal;
    int soalNumerik;
    int soalLogika;
    int soalGambar;

    int urutanJenisSoal = 0;

    String namaCalonMahasiswa;

    @RequestMapping(value = "mulai", method = RequestMethod.GET)
    public String ujianMulai(ModelMap modelMap, @RequestParam(value = "noPendaftaran") String noPendaftaran) {
        if (!(noPendaftaran).matches("\\p{Digit}+")) {
            modelMap.addAttribute("param", "gagal");
            return "login-peserta";
        }
        int waktuVerbal = settingService.getSetting().getWaktuPengerjaanVerbal();
        int waktuNumerik = settingService.getSetting().getWaktuPengerjaanNumerik();
        int waktuLogikal = settingService.getSetting().getWaktuPengerjaanLogikal();
        int waktuGambar = settingService.getSetting().getWaktuPengerjaanGambar();
        if (this.noPendaftaran == 0L) {
            waktuPengerjaanVerbal = CalendarUtil.timeToStringUjian(new GregorianCalendar(), waktuVerbal);
            waktuPengerjaanNumerik = CalendarUtil.timeToStringUjian(new GregorianCalendar(), (waktuVerbal + waktuNumerik));
            waktuPengerjaanLogikal = CalendarUtil.timeToStringUjian(new GregorianCalendar(), (waktuVerbal + waktuNumerik + waktuLogikal));
            waktuPengerjaanGambar = CalendarUtil.timeToStringUjian(new GregorianCalendar(), (waktuVerbal + waktuNumerik + waktuLogikal + waktuGambar));

        } else {
            if (this.noPendaftaran != Long.parseLong(noPendaftaran)) {
                waktuPengerjaanVerbal = CalendarUtil.timeToStringUjian(new GregorianCalendar(), waktuVerbal);
                waktuPengerjaanNumerik = CalendarUtil.timeToStringUjian(new GregorianCalendar(), (waktuVerbal + waktuNumerik));
                waktuPengerjaanLogikal = CalendarUtil.timeToStringUjian(new GregorianCalendar(), (waktuVerbal + waktuNumerik + waktuLogikal));
                waktuPengerjaanGambar = CalendarUtil.timeToStringUjian(new GregorianCalendar(), (waktuVerbal + waktuNumerik + waktuLogikal + waktuGambar));
            }
        }
        this.noPendaftaran = Long.parseLong(noPendaftaran);
        CalonMahasiswa calonMahasiswa = calonMahasiswaService.findCalonMahasiswa(this.noPendaftaran);

        if (calonMahasiswa != null) {
            CalonMahasiswa cm = new CalonMahasiswa();
            cm.setId(this.noPendaftaran);
            ujian = new Ujian();
            ujian = ujianService.findUjianByPendaftaran(cm);

            if (ujian == null) {
                ujian = new Ujian();
                ujian.setCalonMahasiswa(cm);
                this.getAllSoals();
                List<PengerjaanSoal> pengerjaanSoals = new ArrayList<PengerjaanSoal>();
                Jawaban jawaban = new Jawaban();
                jawaban.setId(2L);
                for (int i = 0; i < allSoals.size(); i++) {
                    PengerjaanSoal pengerjaanSoal = new PengerjaanSoal();
                    pengerjaanSoal.setSoal(allSoals.get(i));
                    pengerjaanSoal.setJawaban(jawaban);
                    pengerjaanSoals.add(pengerjaanSoal);
                }

                ujian.setPengerjaanSoalList(pengerjaanSoals);

                     ujianService.save(ujian);

                this.pengerjaanSoals = pengerjaanSoals;

            } else {
                if (ujian.getHasil()==null){
                    pengerjaanSoals = ujianService.findPengerjaanSoalByPendaftaran(cm);
                    soalVerbal=settingService.getSetting().getJumlahSoalSinonimTampil()+settingService.getSetting().getJumlahSoalAntonimTampil()+settingService.getSetting().getJumlahSoalPadananTampil();
                    soalNumerik=settingService.getSetting().getJumlahSoalSeriAngkaTampil()+settingService.getSetting().getJumlahSoalSeriHurufTampil()+settingService.getSetting().getJumlahSoalTeknikalTampil();
                    soalLogika=settingService.getSetting().getJumlahSoalLogikalTampil();
                    soalGambar=settingService.getSetting().getJumlahSoalGambarTampil();
                }else {
                    modelMap.addAttribute("param", "pernah");
                    return "login-peserta";
                }
            }
            this.namaCalonMahasiswa = calonMahasiswa.getNama();
            modelMap.addAttribute("namaPeserta", calonMahasiswa.getNama());
            modelMap.addAttribute("ujian", ConstantUtils.tampilkanDiPanelPengerjaanSoal(pengerjaanSoals, 0, (soalVerbal - 1)));
            modelMap.addAttribute("nomor", "0");
            modelMap.addAttribute("url", "/cbt-pmb/ujian");
            modelMap.addAttribute("url_hasil", "/cbt-pmb/ujian?page=2");
            modelMap.addAttribute("waktu", waktuPengerjaanVerbal);

            modelMap.addAttribute("jSoalSinonim", settingService.getSetting().getJumlahSoalSinonimTampil());
            modelMap.addAttribute("jSoalAntonim", settingService.getSetting().getJumlahSoalAntonimTampil());
            modelMap.addAttribute("jSoalPadanan", settingService.getSetting().getJumlahSoalPadananTampil());
            return "cbt-page";
        } else {
            modelMap.addAttribute("param", "gagal");
            return "login-peserta";
        }
    }


    @RequestMapping(method = RequestMethod.GET)
    public String find(ModelMap modelMap, @RequestParam(value = "page", defaultValue = "1") int page) {

        if (page == 2) {
            modelMap.addAttribute("namaPeserta", namaCalonMahasiswa);
            modelMap.addAttribute("ujian", ConstantUtils.tampilkanDiPanelPengerjaanSoal(pengerjaanSoals, soalVerbal, (soalVerbal + soalNumerik - 1)));
            modelMap.addAttribute("nomor", soalVerbal + "");
            modelMap.addAttribute("mulai", soalVerbal + "");
            modelMap.addAttribute("url", "/cbt-pmb/ujian");
            modelMap.addAttribute("url_hasil", "/cbt-pmb/ujian?page=3");
            modelMap.addAttribute("waktu", waktuPengerjaanNumerik);
            modelMap.addAttribute("jSoalSeriAngka", settingService.getSetting().getJumlahSoalSeriAngkaTampil());
            modelMap.addAttribute("jSoalSeriHuruf", settingService.getSetting().getJumlahSoalSeriHurufTampil());
            modelMap.addAttribute("jSoalTeknikal", settingService.getSetting().getJumlahSoalTeknikalTampil());
            return "cbt/numerik-page";
        }
        if (page == 3) {
            modelMap.addAttribute("namaPeserta", namaCalonMahasiswa);
            modelMap.addAttribute("ujian", ConstantUtils.tampilkanDiPanelPengerjaanSoal(pengerjaanSoals, (soalVerbal + soalNumerik), (soalVerbal + soalNumerik + soalLogika - 1)));
            modelMap.addAttribute("nomor", (soalVerbal + soalNumerik) + "");
            modelMap.addAttribute("url", "/cbt-pmb/ujian");
            modelMap.addAttribute("url_hasil", "/cbt-pmb/ujian?page=4");
            modelMap.addAttribute("waktu", waktuPengerjaanLogikal);
            return "cbt/logikal-page";
        }
        if (page == 4) {
            modelMap.addAttribute("namaPeserta", namaCalonMahasiswa);
            modelMap.addAttribute("ujian", ConstantUtils.tampilkanDiPanelPengerjaanSoal(pengerjaanSoals, (soalVerbal + soalNumerik + soalLogika), (soalVerbal + soalNumerik + soalLogika + soalGambar - 1)));
            modelMap.addAttribute("nomor", (soalVerbal + soalNumerik + soalLogika) + "");
            modelMap.addAttribute("url", "/cbt-pmb/ujian");
            modelMap.addAttribute("url_hasil", "/cbt-pmb/ujian/hasil");
            modelMap.addAttribute("waktu", waktuPengerjaanGambar);
            return "cbt/gambar-page";
        }
        modelMap.addAttribute("ujian", ConstantUtils.tampilkanDiPanelPengerjaanSoal(pengerjaanSoals, 0, (soalVerbal - 1)));
        modelMap.addAttribute("nomor", "0");
        modelMap.addAttribute("url", "/cbt-pmb/ujian");
        modelMap.addAttribute("url_hasil", "/cbt-pmb/ujian?page=2");
        modelMap.addAttribute("waktu", waktuPengerjaanVerbal);
        modelMap.addAttribute("jSoalSinonim", settingService.getSetting().getJumlahSoalSinonimTampil());
        modelMap.addAttribute("jSoalAntonim", settingService.getSetting().getJumlahSoalAntonimTampil());
        modelMap.addAttribute("jSoalPadanan", settingService.getSetting().getJumlahSoalPadananTampil());
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
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        CalonMahasiswa cm = new CalonMahasiswa();
        cm.setId(noPendaftaran);

        ujian = ujianService.findUjianByPendaftaran(cm);


        List<PengerjaanSoal> allPengerjaanSoal = ujian.getPengerjaanSoalList();
        List<PengerjaanSoal> allPengerjaanVerbal = ConstantUtils.tampilkanDiPanelPengerjaanSoal(allPengerjaanSoal, 0, (soalVerbal - 1));
        List<PengerjaanSoal> allPengerjaanNumerik = ConstantUtils.tampilkanDiPanelPengerjaanSoal(allPengerjaanSoal, soalVerbal, (soalVerbal + soalNumerik - 1));
        List<PengerjaanSoal> allPengerjaanLogika = ConstantUtils.tampilkanDiPanelPengerjaanSoal(allPengerjaanSoal, (soalVerbal + soalNumerik), (soalVerbal + soalNumerik + soalLogika - 1));
        List<PengerjaanSoal> allPengerjaanGambar = ConstantUtils.tampilkanDiPanelPengerjaanSoal(allPengerjaanSoal, (soalVerbal + soalNumerik + soalLogika), (soalVerbal + soalNumerik + soalLogika + soalGambar - 1));

        int benarSoalVerbal = 0;
        for (PengerjaanSoal pengerjaanSoal : allPengerjaanVerbal) {
            if (pengerjaanSoal.getJawaban() != null && pengerjaanSoal.getJawaban().getKebenaran()) {
                benarSoalVerbal++;
            }
        }
        float hasilVerbal = ((float) benarSoalVerbal / allPengerjaanSoal.size()) * (float) 100;
        hasilVerbal=Float.valueOf(twoDForm.format(hasilVerbal));

        int benarSoalNumerik = 0;
        for (PengerjaanSoal pengerjaanSoal : allPengerjaanNumerik) {
            if (pengerjaanSoal.getJawaban() != null && pengerjaanSoal.getJawaban().getKebenaran()) {
                benarSoalNumerik++;
            }
        }
        float hasilNumerik = ((float) benarSoalNumerik / allPengerjaanVerbal.size()) * (float) 100;
        hasilNumerik=Float.valueOf(twoDForm.format(hasilNumerik));

        int benarSoalLogika = 0;
        for (PengerjaanSoal pengerjaanSoal : allPengerjaanVerbal) {
            if (pengerjaanSoal.getJawaban() != null && pengerjaanSoal.getJawaban().getKebenaran()) {
                benarSoalLogika++;
            }
        }
        float hasilLogika = ((float) benarSoalLogika / allPengerjaanLogika.size()) * (float) 100;
        hasilLogika=Float.valueOf(twoDForm.format(hasilLogika));

        int benarSoalGambar = 0;
        for (PengerjaanSoal pengerjaanSoal : allPengerjaanVerbal) {
            if (pengerjaanSoal.getJawaban() != null && pengerjaanSoal.getJawaban().getKebenaran()) {
                benarSoalGambar++;
            }
        }
        float hasilGambar = ((float) benarSoalGambar / allPengerjaanGambar.size()) * (float) 100;
        hasilGambar=Float.valueOf(twoDForm.format(hasilGambar));

        int benarALlSoal = 0;
        for (PengerjaanSoal pengerjaanSoal : allPengerjaanSoal) {
            if (pengerjaanSoal.getJawaban() != null && pengerjaanSoal.getJawaban().getKebenaran()) {
                benarALlSoal++;
            }
        }
        float hasil = ((float) benarALlSoal / allPengerjaanSoal.size()) * (float) 100;
        hasil=Float.valueOf(twoDForm.format(hasil));

        ujian.setNilaiVerbal(hasilVerbal);
        ujian.setNilaiNumerik(hasilNumerik);
        ujian.setNilaiLogika(hasilLogika);
        ujian.setNilaiGambar(hasilGambar);
        ujian.setHasil(hasil);

        ujianService.save(ujian);
        modelMap.addAttribute("noPendaftaran", noPendaftaran);
        modelMap.addAttribute("nama", namaCalonMahasiswa);
        modelMap.addAttribute("verbal", hasilVerbal);
        modelMap.addAttribute("numerik", hasilNumerik);
        modelMap.addAttribute("logika", hasilLogika);
        modelMap.addAttribute("gambar", hasilGambar);
        modelMap.addAttribute("hasil", hasil);
        return "cbt/hasil";

    }

    @RequestMapping(value = "search/form", method = RequestMethod.GET)
    public String formSearch(ModelMap modelMap) {
        modelMap.addAttribute("event", "SEARCH");
        modelMap.addAttribute("httpMethod", "POST");
        modelMap.addAttribute("ujian", new Ujian());
        return "hasil/input";
    }

    @RequestMapping(value="search",method = RequestMethod.GET)
    public String search(ModelMap modelMap,
                         @RequestParam(value = "noPendaftaran") Long id){
        CalonMahasiswa calonMahasiswa=new CalonMahasiswa();
        calonMahasiswa.setId(id);
        Ujian singleUjian=ujianService.findUjianByPendaftaran(calonMahasiswa);
        modelMap.addAttribute("hasil", singleUjian);
        return "hasil/singglelist";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String getSearching(@ModelAttribute("ujian") Ujian ujian1) {

        return "redirect:/ujian/search?"
                + (ujian1.getId()==null?"":("id="+ujian1.getId()));

    }

    public void getAllSoals() {
        getSoalVerbals();
        getSoalNumerik();
        getSoalLogikals();
        getSoalGambars();

        allSoals = new ArrayList<Soal>();
        for (Soal soal : soalVerbals) {
            allSoals.add(soal);
        }
        for (Soal soal : soalNumeriks) {
            allSoals.add(soal);
        }
        for (Soal soal : soalLogikals) {
            allSoals.add(soal);
        }
        for (Soal soal : soalGambars) {
            allSoals.add(soal);
        }
    }

    public void getSoalVerbals() {
        soalVerbals = new ArrayList<Soal>();
        int jumlahSoalSinonim = settingService.getSetting().getJumlahSoalSinonimTampil();
        int jumlahSoalAntonim = settingService.getSetting().getJumlahSoalAntonimTampil();
        int jumlahSoalPadanan = settingService.getSetting().getJumlahSoalPadananTampil();
        this.soalVerbal = jumlahSoalAntonim + jumlahSoalPadanan + jumlahSoalSinonim;
        List<Soal> soalSinonims = soalService.findSoalsByKategori(1L, jumlahSoalSinonim);
        soalSinonims = setRandomSoal(soalSinonims);

        for (Soal soal : soalSinonims) {
            soal.setView(soal.getView() + 1);
            soalService.save(soal);
            soal.setJawabans(setRandomJawaban(soal.getJawabans()));
            soalVerbals.add(soal);
        }

        List<Soal> soalAntonims = soalService.findSoalsByKategori(2L, jumlahSoalAntonim);
        soalAntonims = setRandomSoal(soalAntonims);
        for (Soal soal : soalAntonims) {
            soal.setView(soal.getView() + 1);
            soalService.save(soal);
            soal.setJawabans(setRandomJawaban(soal.getJawabans()));
            soalVerbals.add(soal);
        }

        List<Soal> soalPadanans = soalService.findSoalsByKategori(3L, jumlahSoalPadanan);
        soalPadanans = setRandomSoal(soalPadanans);
        for (Soal soal : soalPadanans) {
            soal.setView(soal.getView() + 1);
            soalService.save(soal);
            soal.setJawabans(setRandomJawaban(soal.getJawabans()));
            soalVerbals.add(soal);
        }

    }

    public void getSoalNumerik() {
        soalNumeriks = new ArrayList<Soal>();
        int jumlahSoalSeriAngka = settingService.getSetting().getJumlahSoalSeriAngkaTampil();
        int jumlahSoalSeriHuruf = settingService.getSetting().getJumlahSoalSeriHurufTampil();
        int jumlahSoalTeknikal = settingService.getSetting().getJumlahSoalTeknikalTampil();
        this.soalNumerik = jumlahSoalSeriAngka + jumlahSoalSeriHuruf + jumlahSoalTeknikal;
        List<Soal> soalSAngkas = soalService.findSoalsByKategori(4L, jumlahSoalSeriAngka);
        soalSAngkas = setRandomSoal(soalSAngkas);

        for (Soal soal : soalSAngkas) {
            soal.setView(soal.getView() + 1);
            soalService.save(soal);
            soal.setJawabans(setRandomJawaban(soal.getJawabans()));
            soalNumeriks.add(soal);
        }

        List<Soal> soalSHurufs = soalService.findSoalsByKategori(5L, jumlahSoalSeriHuruf);
        soalSHurufs = setRandomSoal(soalSHurufs);
        for (Soal soal : soalSHurufs) {
            soal.setView(soal.getView() + 1);
            soalService.save(soal);
            soal.setJawabans(setRandomJawaban(soal.getJawabans()));
            soalNumeriks.add(soal);
        }

        List<Soal> soalTeknikals = soalService.findSoalsByKategori(6L, jumlahSoalTeknikal);
        soalTeknikals = setRandomSoal(soalTeknikals);
        for (Soal soal : soalTeknikals) {
            soal.setView(soal.getView() + 1);
            soalService.save(soal);
            soal.setJawabans(setRandomJawaban(soal.getJawabans()));
            soalNumeriks.add(soal);
        }

    }

    public void getSoalGambars() {
        soalGambars = new ArrayList<Soal>();
        int jumlahSoalGambar = settingService.getSetting().getJumlahSoalGambarTampil();
        this.soalGambar = jumlahSoalGambar;
        List<Soal> soalGambarList = soalService.findSoalsByKategori(8L, jumlahSoalGambar);
        soalGambarList = setRandomSoal(soalGambarList);

        for (Soal soal : soalGambarList) {
            soal.setView(soal.getView() + 1);
            soalService.save(soal);
            soal.setJawabans(setRandomJawaban(soal.getJawabans()));
            soalGambars.add(soal);
        }

    }

    public void getSoalLogikals() {
        soalLogikals = new ArrayList<Soal>();
        int jumlahSoalLogika = settingService.getSetting().getJumlahSoalLogikalTampil();
        this.soalLogika = jumlahSoalLogika;
        List<Soal> soalLogikalList = soalService.findSoalsByKategori(7L, jumlahSoalLogika);
        soalLogikalList = setRandomSoal(soalLogikalList);

        for (Soal soal : soalLogikalList) {
            soal.setView(soal.getView() + 1);
            soalService.save(soal);
            soal.setJawabans(setRandomJawaban(soal.getJawabans()));
            soalLogikals.add(soal);
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
        Jawaban jawaban = new Jawaban();
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

    @InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(Ujian.class, new UjianEditor(ujianService));
        binder.registerCustomEditor(PengerjaanSoal.class, new PengerjaanSoalEditor(pengerjaanSoalService));
    }
}
