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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Qualifier("gradeLulusService")
    private GradeLulusService gradeLulusService;

    @Autowired
    @Qualifier("pengerjaanSoalService")
    private PengerjaanSoalService pengerjaanSoalService;

    @Autowired
    @Qualifier("calonMahasiswaService")
    private CalonMahasiswaService calonMahasiswaService;

    int soalVerbal;
    int soalNumerik;
    int soalLogika;
    int soalGambar;

   // String namaCalonMahasiswa;

    @RequestMapping(value = "mulai", method = RequestMethod.GET)
    public String ujianMulai(ModelMap modelMap, @RequestParam(value = "noPendaftaran") String noPendaftaran, HttpServletRequest request) {

        if (!(noPendaftaran).matches("\\p{Digit}+")) {
            modelMap.addAttribute("param", "gagal");
            return "login-peserta";
        }
        List<PengerjaanSoal> pengerjaanSoals=new ArrayList<PengerjaanSoal>();

        CalonMahasiswa calonMahasiswa = calonMahasiswaService.findCalonMahasiswa(Long.valueOf(noPendaftaran));

        if (calonMahasiswa != null) {
            HttpSession session=request.getSession();
            session.setAttribute("noPendaftaran",noPendaftaran);
            
            Ujian ujian = new Ujian();
            ujian = ujianService.findUjianByPendaftaran(calonMahasiswa);

            if (ujian == null) {
                ujian = new Ujian();
                ujian.setCalonMahasiswa(calonMahasiswa);
                List<Soal> allSoals=getAllSoals();
                List<PengerjaanSoal> siapPengerjaanSoals = new ArrayList<PengerjaanSoal>();
                Jawaban jawaban = new Jawaban();
                jawaban.setId(2L);
                for (int i = 0; i < allSoals.size(); i++) {
                    PengerjaanSoal pengerjaanSoal = new PengerjaanSoal();
                    pengerjaanSoal.setSoal(allSoals.get(i));
                    pengerjaanSoal.setJawaban(jawaban);
                    siapPengerjaanSoals.add(pengerjaanSoal);
                }

                ujian.setPengerjaanSoalList(siapPengerjaanSoals);

                     ujianService.save(ujian);
                pengerjaanSoals = ujianService.findPengerjaanSoalByPendaftaran(calonMahasiswa);
            } else {
                if (ujian.getHasil()==null){
                    pengerjaanSoals = ujianService.findPengerjaanSoalByPendaftaran(calonMahasiswa);
                    soalVerbal=settingService.getSetting().getJumlahSoalSinonimTampil()+settingService.getSetting().getJumlahSoalAntonimTampil()+settingService.getSetting().getJumlahSoalPadananTampil();
                    soalNumerik=settingService.getSetting().getJumlahSoalSeriAngkaTampil()+settingService.getSetting().getJumlahSoalSeriHurufTampil()+settingService.getSetting().getJumlahSoalTeknikalTampil();
                    soalLogika=settingService.getSetting().getJumlahSoalLogikalTampil();
                    soalGambar=settingService.getSetting().getJumlahSoalGambarTampil();
                }else {
                    modelMap.addAttribute("param", "pernah");
                    return "login-peserta";
                }
            }
            modelMap.addAttribute("namaPeserta", calonMahasiswa.getNama());
            modelMap.addAttribute("ujian", ConstantUtils.tampilkanDiPanelPengerjaanSoal(pengerjaanSoals, 0, soalVerbal));
            modelMap.addAttribute("nomor", "0");
            modelMap.addAttribute("url", "/cbt-pmb/ujian");
            modelMap.addAttribute("url_hasil", "/cbt-pmb/ujian?page=2");
            modelMap.addAttribute("waktu", CalendarUtil.timeToStringUjian(new GregorianCalendar(),settingService.getSetting().getWaktuPengerjaanVerbal()));

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
    public String find(ModelMap modelMap, @RequestParam(value = "page", defaultValue = "1") int page,HttpServletRequest request) {
            HttpSession session=request.getSession();
        CalonMahasiswa calonMahasiswa=calonMahasiswaService.findCalonMahasiswa(Long.valueOf(session.getAttribute("noPendaftaran")+""));
        List<PengerjaanSoal> pengerjaanSoals=ujianService.findPengerjaanSoalByPendaftaran(calonMahasiswa);
        if (page == 2) {
            modelMap.addAttribute("namaPeserta", calonMahasiswa.getNama());
            modelMap.addAttribute("ujian", ConstantUtils.tampilkanDiPanelPengerjaanSoal(pengerjaanSoals, soalVerbal, (soalVerbal + soalNumerik )));
            modelMap.addAttribute("nomor", soalVerbal + "");
            modelMap.addAttribute("mulai", (soalVerbal+1) + "");
            modelMap.addAttribute("url", "/cbt-pmb/ujian");
            modelMap.addAttribute("url_hasil", "/cbt-pmb/ujian?page=3");
            modelMap.addAttribute("waktu", CalendarUtil.timeToStringUjian(new GregorianCalendar(),settingService.getSetting().getWaktuPengerjaanNumerik()));
            modelMap.addAttribute("jSoalSeriAngka", settingService.getSetting().getJumlahSoalSeriAngkaTampil());
            modelMap.addAttribute("jSoalSeriHuruf", settingService.getSetting().getJumlahSoalSeriHurufTampil());
            modelMap.addAttribute("jSoalTeknikal", settingService.getSetting().getJumlahSoalTeknikalTampil());
            return "cbt/numerik-page";
        }
        if (page == 3) {
            modelMap.addAttribute("namaPeserta", calonMahasiswa.getNama());
            modelMap.addAttribute("ujian", ConstantUtils.tampilkanDiPanelPengerjaanSoal(pengerjaanSoals, (soalVerbal + soalNumerik), (soalVerbal + soalNumerik + soalLogika )));
            modelMap.addAttribute("nomor", (soalVerbal + soalNumerik) + "");
            modelMap.addAttribute("url", "/cbt-pmb/ujian");
            modelMap.addAttribute("url_hasil", "/cbt-pmb/ujian?page=4");
            modelMap.addAttribute("waktu", CalendarUtil.timeToStringUjian(new GregorianCalendar(),settingService.getSetting().getWaktuPengerjaanLogikal()));
            return "cbt/logikal-page";
        }
        if (page == 4) {
            modelMap.addAttribute("namaPeserta", calonMahasiswa.getNama());
            modelMap.addAttribute("ujian", ConstantUtils.tampilkanDiPanelPengerjaanSoal(pengerjaanSoals, (soalVerbal + soalNumerik + soalLogika), (soalVerbal + soalNumerik + soalLogika + soalGambar)));
            modelMap.addAttribute("nomor", (soalVerbal + soalNumerik + soalLogika) + "");
            modelMap.addAttribute("url", "/cbt-pmb/ujian");
            modelMap.addAttribute("url_hasil", "/cbt-pmb/ujian/hasil");
            modelMap.addAttribute("waktu", CalendarUtil.timeToStringUjian(new GregorianCalendar(),settingService.getSetting().getWaktuPengerjaanGambar()));
            return "cbt/gambar-page";
        }
        modelMap.addAttribute("ujian", ConstantUtils.tampilkanDiPanelPengerjaanSoal(pengerjaanSoals, 0, (soalVerbal)));
        modelMap.addAttribute("nomor", "0");
        modelMap.addAttribute("url", "/cbt-pmb/ujian");
        modelMap.addAttribute("url_hasil", "/cbt-pmb/ujian?page=2");
        modelMap.addAttribute("waktu", CalendarUtil.timeToStringUjian(new GregorianCalendar(),settingService.getSetting().getWaktuPengerjaanVerbal()));
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
    public String hasil(ModelMap modelMap,HttpServletRequest request) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        HttpSession session=request.getSession();
        CalonMahasiswa cm = calonMahasiswaService.findCalonMahasiswa(Long.valueOf(session.getAttribute("noPendaftaran")+""));

        Ujian ujian = ujianService.findUjianByPendaftaran(cm);


        List<PengerjaanSoal> allPengerjaanSoal = ujian.getPengerjaanSoalList();
        //allPengerjaanSoal.
        List<PengerjaanSoal> allPengerjaanVerbal = new ArrayList<PengerjaanSoal>();
        for(PengerjaanSoal ps:allPengerjaanSoal){
            if(ps.getSoal().getKategori().getJenisSoal().getNama().equals("TES BAHASA")){
                allPengerjaanVerbal.add(ps);

            }
        }
        List<PengerjaanSoal> allPengerjaanNumerik = new ArrayList<PengerjaanSoal>();
        for(PengerjaanSoal ps:allPengerjaanSoal){
            if(ps.getSoal().getKategori().getJenisSoal().getNama().equals("TES ANGKA")){
                allPengerjaanNumerik.add(ps);

            }
        }
        List<PengerjaanSoal> allPengerjaanLogika = new ArrayList<PengerjaanSoal>();
        for(PengerjaanSoal ps:allPengerjaanSoal){
            if(ps.getSoal().getKategori().getJenisSoal().getNama().equals("TES LOGIKA")){
                allPengerjaanLogika.add(ps);

            }
        }
        List<PengerjaanSoal> allPengerjaanGambar = new ArrayList<PengerjaanSoal>();
        for(PengerjaanSoal ps:allPengerjaanSoal){
            if(ps.getSoal().getKategori().getJenisSoal().getNama().equals("TES GAMBAR")){
                allPengerjaanGambar.add(ps);

            }
        }

        int benarSoalVerbal = 0;
        for (PengerjaanSoal pengerjaanSoal : allPengerjaanVerbal) {
            if (pengerjaanSoal.getJawaban() != null && pengerjaanSoal.getJawaban().getKebenaran()) {
                benarSoalVerbal++;
            }
        }
        float hasilVerbal = ((float) benarSoalVerbal / allPengerjaanVerbal.size()) * (float) 100;
        hasilVerbal=Float.valueOf(twoDForm.format(hasilVerbal));

        int benarSoalNumerik = 0;
        for (PengerjaanSoal pengerjaanSoal : allPengerjaanNumerik) {
            if (pengerjaanSoal.getJawaban() != null && pengerjaanSoal.getJawaban().getKebenaran()) {
                benarSoalNumerik++;
            }
        }
        float hasilNumerik = ((float) benarSoalNumerik / allPengerjaanNumerik.size()) * (float) 100;
        hasilNumerik=Float.valueOf(twoDForm.format(hasilNumerik));

        int benarSoalLogika = 0;
        for (PengerjaanSoal pengerjaanSoal : allPengerjaanLogika) {
            if (pengerjaanSoal.getJawaban() != null && pengerjaanSoal.getJawaban().getKebenaran()) {
                benarSoalLogika++;
            }
        }
        float hasilLogika = ((float) benarSoalLogika / allPengerjaanLogika.size()) * (float) 100;
        hasilLogika=Float.valueOf(twoDForm.format(hasilLogika));

        int benarSoalGambar = 0;
        for (PengerjaanSoal pengerjaanSoal : allPengerjaanGambar) {
            if (pengerjaanSoal.getJawaban() != null && pengerjaanSoal.getJawaban().getKebenaran()) {
                benarSoalGambar++;
            }
        }
        float hasilGambar = ((float) benarSoalGambar / allPengerjaanGambar.size()) * (float) 100;
        hasilGambar=Float.valueOf(twoDForm.format(hasilGambar));

//        int benarALlSoal = 0;
//        for (PengerjaanSoal pengerjaanSoal : allPengerjaanSoal) {
//            if (pengerjaanSoal.getJawaban() != null && pengerjaanSoal.getJawaban().getKebenaran()) {
//                benarALlSoal++;
//            }
//        }
        float hasil = 0f; //((float) benarALlSoal / allPengerjaanSoal.size()) * (float) 100;
        hasil=(hasilVerbal+hasilNumerik+hasilLogika+hasilGambar)/4;
        hasil=Float.valueOf(twoDForm.format(hasil));

        ujian.setNilaiVerbal(hasilVerbal);
        ujian.setNilaiNumerik(hasilNumerik);
        ujian.setNilaiLogika(hasilLogika);
        ujian.setNilaiGambar(hasilGambar);
        ujian.setHasil(hasil);

        ujianService.save(ujian);
        modelMap.addAttribute("noPendaftaran", cm.getId());
        modelMap.addAttribute("nama", cm.getNama());
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

    @RequestMapping(value = "print", method = RequestMethod.GET)
    public String print(ModelMap modelMap, @RequestParam(value = "id") Long id) {
        CalonMahasiswa calonMahasiswa=calonMahasiswaService.findCalonMahasiswa(id);
        Long pilihanPertama=1l;
        Long pilihanKedua=1l;
        Ujian ujian1=ujianService.findUjianByPendaftaran(calonMahasiswa);
        if(calonMahasiswa.getPilihanPertama().equals("tp")){
            calonMahasiswa.setPilihanPertama("T Penerbangan");
            pilihanPertama=1L;
        }
        if(calonMahasiswa.getPilihanPertama().equals("tf")){
            calonMahasiswa.setPilihanPertama("T Informatika");
            pilihanPertama=2L;
        }
        if(calonMahasiswa.getPilihanPertama().equals("ti")){
            calonMahasiswa.setPilihanPertama("T Industri");
            pilihanPertama=3L;
        }
        if(calonMahasiswa.getPilihanPertama().equals("tm")){
            calonMahasiswa.setPilihanPertama("T Mesin");
            pilihanPertama=4L;
        }
        if(calonMahasiswa.getPilihanPertama().equals("te")){
            calonMahasiswa.setPilihanPertama("T Elektro");
            pilihanPertama=5L;
        }
        if(calonMahasiswa.getPilihanKedua().equals("tp")){
            calonMahasiswa.setPilihanKedua("T Penerbangan");
            pilihanKedua=1L;
        }
        if(calonMahasiswa.getPilihanKedua().equals("tf")){
            calonMahasiswa.setPilihanKedua("T Informatika");
            pilihanKedua=2L;
        }
        if(calonMahasiswa.getPilihanKedua().equals("ti")){
            calonMahasiswa.setPilihanKedua("T Industri");
            pilihanKedua=3L;
        }
        if(calonMahasiswa.getPilihanKedua().equals("tm")){
            calonMahasiswa.setPilihanKedua("T Mesin");
            pilihanKedua=4L;
        }
        if(calonMahasiswa.getPilihanKedua().equals("te")){
            calonMahasiswa.setPilihanKedua("T Elektro");
            pilihanKedua=5L;
        }
        
        modelMap.addAttribute("nomor",calonMahasiswa.getId());
        modelMap.addAttribute("nama",calonMahasiswa.getNama());
        modelMap.addAttribute("pilihanPertama",calonMahasiswa.getPilihanPertama());
        modelMap.addAttribute("pilihanKedua",calonMahasiswa.getPilihanKedua());
        modelMap.addAttribute("verbal",ujian1.getNilaiVerbal());
        modelMap.addAttribute("numerik",ujian1.getNilaiNumerik());
        modelMap.addAttribute("logika",ujian1.getNilaiLogika());
        modelMap.addAttribute("gambar",ujian1.getNilaiGambar());
        modelMap.addAttribute("nilaiAkhir",ujian1.getHasil());
        modelMap.addAttribute("gradeVerbal1",gradeLulusService.getGradeLulus(pilihanPertama).getBatasVerbal());
        modelMap.addAttribute("gradeVerbal2",gradeLulusService.getGradeLulus(pilihanKedua).getBatasVerbal());
        modelMap.addAttribute("gradeNumerik1",gradeLulusService.getGradeLulus(pilihanPertama).getBatasNumerik());
        modelMap.addAttribute("gradeNumerik2",gradeLulusService.getGradeLulus(pilihanKedua).getBatasNumerik());
        modelMap.addAttribute("gradeLogika1",gradeLulusService.getGradeLulus(pilihanPertama).getBatasLogika());
        modelMap.addAttribute("gradeLogika2",gradeLulusService.getGradeLulus(pilihanKedua).getBatasLogika());
        modelMap.addAttribute("gradeGambar1",gradeLulusService.getGradeLulus(pilihanPertama).getBatasGambar());
        modelMap.addAttribute("gradeGambar2",gradeLulusService.getGradeLulus(pilihanKedua).getBatasGambar());
        if(ujian1.getNilaiGambar()>=gradeLulusService.getGradeLulus(pilihanPertama).getBatasGambar() &&
                ujian1.getNilaiLogika()>=gradeLulusService.getGradeLulus(pilihanPertama).getBatasLogika() &&
                ujian1.getNilaiNumerik()>=gradeLulusService.getGradeLulus(pilihanPertama).getBatasNumerik() &&
                ujian1.getNilaiVerbal()>=gradeLulusService.getGradeLulus(pilihanPertama).getBatasVerbal()){
            modelMap.addAttribute("lulus1","LULUS");
        }                                           else{
            modelMap.addAttribute("lulus1","TIDAK LULUS");
        }
        if(ujian1.getNilaiGambar()>=gradeLulusService.getGradeLulus(pilihanKedua).getBatasGambar() &&
                ujian1.getNilaiLogika()>=gradeLulusService.getGradeLulus(pilihanKedua).getBatasLogika() &&
                ujian1.getNilaiNumerik()>=gradeLulusService.getGradeLulus(pilihanKedua).getBatasNumerik() &&
                ujian1.getNilaiVerbal()>=gradeLulusService.getGradeLulus(pilihanKedua).getBatasVerbal()){
            modelMap.addAttribute("lulus2","LULUS");
        }                                           else{
            modelMap.addAttribute("lulus2","TIDAK LULUS");
        }
         return "hasil/print-page";
    }

    public List<Soal> getAllSoals() {

        List<Soal> allSoals = new ArrayList<Soal>();
        for (Soal soal : getSoalVerbals()) {
            allSoals.add(soal);
        }
        for (Soal soal : getSoalNumerik()) {
            allSoals.add(soal);
        }
        for (Soal soal : getSoalLogikals()) {
            allSoals.add(soal);
        }
        for (Soal soal : getSoalGambars()) {
            allSoals.add(soal);
        }
        return allSoals;
    }

    public List<Soal> getSoalVerbals() {
        List<Soal> soalVerbals = new ArrayList<Soal>();
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
        return soalVerbals;
    }

    public List<Soal> getSoalNumerik() {
        List<Soal> soalNumeriks = new ArrayList<Soal>();
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
             return soalNumeriks;
    }

    public List<Soal> getSoalGambars() {
        List<Soal> soalGambars = new ArrayList<Soal>();
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
         return  soalGambars;
    }

    public List<Soal> getSoalLogikals() {
        List<Soal>  soalLogikals = new ArrayList<Soal>();
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
           return soalLogikals;
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
