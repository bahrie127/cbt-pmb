package com.bahri.pmb.ui.controller;

import com.bahri.pmb.domain.Kategori;
import com.bahri.pmb.service.CalonMahasiswaService;
import com.bahri.pmb.service.KategoriService;
import com.bahri.pmb.service.UjianService;
import com.bahri.pmb.service.editor.KategoriEditor;
import com.bahri.pmb.simple.Statistik;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: latief
 * Date: 3/19/12
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "statistik")
public class StatistikController {

    @Autowired
    @Qualifier("kategoriService")
    private KategoriService kategoriService;

    @Autowired
    @Qualifier("ujianService")
    private UjianService ujianService;

    @Autowired
    @Qualifier("calonMahasiswaService")
    private CalonMahasiswaService calonMahasiswaService;

    @RequestMapping(value = "navbar", method = RequestMethod.GET)
    public String navBar() {
        return "statistik/navbar";
    }

    @RequestMapping(value = "pertama",method = RequestMethod.GET)
    public String findPilPertama(ModelMap modelMap) {
        List<Statistik> statistikList=new ArrayList<Statistik>();
        Statistik statistikTp=new Statistik();
        statistikTp.setJurusan("T. Penerbangan");
        statistikTp.setJumlah(ujianService.countUjians(1,"tp"));
        statistikTp.setVerbal(ujianService.rataNilaiBidang(1,"tp",1));
        statistikTp.setNumerik(ujianService.rataNilaiBidang(1, "tp", 2));
        statistikTp.setLogikal(ujianService.rataNilaiBidang(1, "tp", 3));
        statistikTp.setGambar(ujianService.rataNilaiBidang(1, "tp", 4));

        Statistik statistikTf=new Statistik();
        statistikTf.setJurusan("T. Informatika");
        statistikTf.setJumlah(ujianService.countUjians(1,"tf"));
        statistikTf.setVerbal(ujianService.rataNilaiBidang(1,"tf",1));
        statistikTf.setNumerik(ujianService.rataNilaiBidang(1,"tf",2));
        statistikTf.setLogikal(ujianService.rataNilaiBidang(1,"tf",3));
        statistikTf.setGambar(ujianService.rataNilaiBidang(1,"tf",4));

        Statistik statistikTi=new Statistik();
        statistikTi.setJurusan("T. Industri");
        statistikTi.setJumlah(ujianService.countUjians(1,"ti"));
        statistikTi.setVerbal(ujianService.rataNilaiBidang(1,"ti",1));
        statistikTi.setNumerik(ujianService.rataNilaiBidang(1,"ti",2));
        statistikTi.setLogikal(ujianService.rataNilaiBidang(1,"ti",3));
        statistikTi.setGambar(ujianService.rataNilaiBidang(1,"ti",4));

        Statistik statistikTm=new Statistik();
        statistikTm.setJurusan("T. Mesin");
        statistikTm.setJumlah(ujianService.countUjians(1,"tm"));
        statistikTm.setVerbal(ujianService.rataNilaiBidang(1,"tm",1));
        statistikTm.setNumerik(ujianService.rataNilaiBidang(1,"tm",2));
        statistikTm.setLogikal(ujianService.rataNilaiBidang(1,"tm",3));
        statistikTm.setGambar(ujianService.rataNilaiBidang(1,"tm",4));

        Statistik statistikTe=new Statistik();
        statistikTe.setJurusan("T. Elektro");
        statistikTe.setJumlah(ujianService.countUjians(1,"te"));
        statistikTe.setVerbal(ujianService.rataNilaiBidang(1,"te",1));
        statistikTe.setNumerik(ujianService.rataNilaiBidang(1,"te",2));
        statistikTe.setLogikal(ujianService.rataNilaiBidang(1,"te",3));
        statistikTe.setGambar(ujianService.rataNilaiBidang(1,"te",4));

        statistikList.add(statistikTp);
        statistikList.add(statistikTf);
        statistikList.add(statistikTi);
        statistikList.add(statistikTm);
        statistikList.add(statistikTe);

        modelMap.addAttribute("statistik1",statistikList);
        return "statistik/listpilihanpertama";
    }

    @RequestMapping(value = "kedua",method = RequestMethod.GET)
    public String findPilKedua(ModelMap modelMap) {
        List<Statistik> statistikList=new ArrayList<Statistik>();
        Statistik statistikTp=new Statistik();
        statistikTp.setJurusan("T. Penerbangan");
        statistikTp.setJumlah(ujianService.countUjians(2,"tp"));
        statistikTp.setVerbal(ujianService.rataNilaiBidang(2,"tp",1));
        statistikTp.setNumerik(ujianService.rataNilaiBidang(2,"tp",2));
        statistikTp.setLogikal(ujianService.rataNilaiBidang(2,"tp",3));
        statistikTp.setGambar(ujianService.rataNilaiBidang(2,"tp",4));

        Statistik statistikTf=new Statistik();
        statistikTf.setJurusan("T. Informatika");
        statistikTf.setJumlah(ujianService.countUjians(2,"tf"));
        statistikTf.setVerbal(ujianService.rataNilaiBidang(2,"tf",1));
        statistikTf.setNumerik(ujianService.rataNilaiBidang(2,"tf",2));
        statistikTf.setLogikal(ujianService.rataNilaiBidang(2,"tf",3));
        statistikTf.setGambar(ujianService.rataNilaiBidang(2,"tf",4));

        Statistik statistikTi=new Statistik();
        statistikTi.setJurusan("T. Industri");
        statistikTi.setJumlah(ujianService.countUjians(2,"ti"));
        statistikTi.setVerbal(ujianService.rataNilaiBidang(2,"ti",1));
        statistikTi.setNumerik(ujianService.rataNilaiBidang(2,"ti",2));
        statistikTi.setLogikal(ujianService.rataNilaiBidang(2,"ti",3));
        statistikTi.setGambar(ujianService.rataNilaiBidang(2,"ti",4));

        Statistik statistikTm=new Statistik();
        statistikTm.setJurusan("T. Mesin");
        statistikTm.setJumlah(ujianService.countUjians(2,"tm"));
        statistikTm.setVerbal(ujianService.rataNilaiBidang(2,"tm",1));
        statistikTm.setNumerik(ujianService.rataNilaiBidang(2,"tm",2));
        statistikTm.setLogikal(ujianService.rataNilaiBidang(2,"tm",3));
        statistikTm.setGambar(ujianService.rataNilaiBidang(2,"tm",4));

        Statistik statistikTe=new Statistik();
        statistikTe.setJurusan("T. Elektro");
        statistikTe.setJumlah(ujianService.countUjians(2,"te"));
        statistikTe.setVerbal(ujianService.rataNilaiBidang(2,"te",1));
        statistikTe.setNumerik(ujianService.rataNilaiBidang(2,"te",2));
        statistikTe.setLogikal(ujianService.rataNilaiBidang(2,"te",3));
        statistikTe.setGambar(ujianService.rataNilaiBidang(2,"te",4));

        statistikList.add(statistikTp);
        statistikList.add(statistikTf);
        statistikList.add(statistikTi);
        statistikList.add(statistikTm);
        statistikList.add(statistikTe);

        modelMap.addAttribute("statistik2",statistikList);
        return "statistik/listpilihankedua";
    }

    @RequestMapping(params = "id", method = RequestMethod.GET)
    public String find(ModelMap modelMap, @RequestParam("id") Kategori kategori) {
        modelMap.addAttribute("event", "DETAIL");
        modelMap.addAttribute("kategori",kategori);
        return "kategori/input";
    }

    @RequestMapping(params = "id", method = RequestMethod.DELETE)
    public @ResponseBody String delete(@RequestParam("id") Kategori kategori) {
        try{
            kategoriService.delete(kategori);
            return "Sukses";
        }catch (HibernateException e){
            return "Gagal";
        }
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        modelMap.addAttribute("event", "INPUT");
        modelMap.addAttribute("httpMethod", "POST");
        modelMap.addAttribute("kategori", new Kategori());
        return "kategori/input";
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String save(@Valid @ModelAttribute("kategori") Kategori kategori, BindingResult bindingResult, ModelMap modelMap){

        if(kategori == null) return "Gagal";
        if(kategori.getNama()==null) return "Gagal";
        if(kategori.getNama().isEmpty()) return "Gagal";
        if(bindingResult.hasErrors()) return "Gagal";

        try{
            kategoriService.save(kategori);
            return "Sukses";
        }catch (HibernateException e){
            return "Gagal";
        }
    }

    @RequestMapping(value = "edit", params = "id", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, @RequestParam("id")Kategori kategori) {

        modelMap.addAttribute("event", "EDIT");
        modelMap.addAttribute("httpMethod", "PUT");
        modelMap.addAttribute("kategori",kategori);
        return "kategori/input";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody String update(@Valid @ModelAttribute("kategori") Kategori kategori, BindingResult bindingResult, ModelMap modelMap){

        if(kategori == null) return "Gagal";
        if(bindingResult.hasErrors()) return "Gagal";

        try{
            kategoriService.save(kategori);
            return "Sukses";
        }catch (HibernateException e){
            return "Gagal";
        }
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception{
        binder.registerCustomEditor(Kategori.class, new KategoriEditor(kategoriService));
    }
}
