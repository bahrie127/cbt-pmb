package com.bahri.pmb.ui.controller;

import com.bahri.pmb.domain.*;
import com.bahri.pmb.service.*;
import com.bahri.pmb.service.editor.PengerjaanSoalEditor;
import com.bahri.pmb.service.editor.UjianEditor;
import com.bahri.pmb.simple.SimpleSoal;
import com.bahri.pmb.util.CalendarUtil;
import com.bahri.pmb.util.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

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

    List<SimpleSoal> soalList = new ArrayList<SimpleSoal>();
    Ujian ujian;
    Long noPendaftaran;

    @RequestMapping(value = "mulai", method = RequestMethod.GET)
    public String ujianMulai(ModelMap modelMap, @RequestParam(value = "noPendaftaran") Long noPendaftaran) {
        this.noPendaftaran = noPendaftaran;
        CalonMahasiswa calonMahasiswa = calonMahasiswaService.findCalonMahasiswa(noPendaftaran);

        if (calonMahasiswa != null) {
            CalonMahasiswa cm = new CalonMahasiswa();
            cm.setId(noPendaftaran);

            ujian = ujianService.findUjianByPendaftaran(cm);

            if (ujian == null) {
                ujian = new Ujian();
                ujian.setCalonMahasiswa(cm);

                List<PengerjaanSoal> pengerjaanSoals = new ArrayList<PengerjaanSoal>();
                for (int i = 0; i < settingService.getSetting().getJumlahSoalTampil(); i++) {
                    PengerjaanSoal pengerjaanSoal = new PengerjaanSoal();
                    pengerjaanSoals.add(pengerjaanSoal);
                }

                ujian.setPengerjaanSoalList(pengerjaanSoals);

                ujianService.save(ujian);
            }

            List<Soal> soals = soalService.findSoals();

            int nomor = 1;
            for (Soal soal : soals) {
                SimpleSoal simpleSoal = new SimpleSoal();
                simpleSoal.setNomor(nomor);
                simpleSoal.setId(soal.getId());
                simpleSoal.setJawabans(soal.getJawabans());
                simpleSoal.setKategori(soal.getKategori());
                simpleSoal.setPertanyaan(soal.getPertanyaan());
                simpleSoal.setView(soal.getView());
                soalList.add(simpleSoal);
                soal.setView((soal.getView() == null ? 0 : soal.getView()) + 1);
                soalService.save(soal);
                nomor++;
            }

            modelMap.addAttribute("namaPeserta", calonMahasiswa.getNama());
            modelMap.addAttribute("tanggal", CalendarUtil.dateToString(new GregorianCalendar()));
            modelMap.addAttribute("ujian", ujian);
            modelMap.addAttribute("nomor", "0");
            modelMap.addAttribute("url", "/cbt-pmb/ujian");
            modelMap.addAttribute("url_hasil", "/cbt-pmb/ujian/hasil");
            modelMap.addAttribute("listSoal", ConstantUtils.tampilkanDiPanelSoal(soalList, ConstantUtils.PAGE_RECORD_SOAL, 1));
            modelMap.addAttribute("countPage", (int) Math.ceil((double) soalList.size() / (double) ConstantUtils.PAGE_RECORD_SOAL));
            return "cbt-page";
        } else {
            modelMap.addAttribute("param", "gagal");
            return "login-peserta";
        }
    }

    public void getSoals(){
        int soalPerkategori= (int) (settingService.getSetting().getJumlahSoalTampil()/kategoriService.countKategoris());
    }


    @RequestMapping(method = RequestMethod.GET)
    public String find(ModelMap modelMap, @RequestParam(value = "page", defaultValue = "1") int page) {
        CalonMahasiswa cm = new CalonMahasiswa();
        cm.setId(noPendaftaran);

        ujian = ujianService.findUjianByPendaftaran(cm);
        modelMap.addAttribute("ujian", ujian);
        modelMap.addAttribute("nomor", ((page - 1) * ConstantUtils.PAGE_RECORD_SOAL) + "");
        modelMap.addAttribute("listSoal", ConstantUtils.tampilkanDiPanelSoal(soalList, ConstantUtils.PAGE_RECORD_SOAL, page));
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
        float hasil=((float)benar/ujian.getPengerjaanSoalList().size())*(float)100;
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
