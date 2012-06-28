package com.bahri.pmb.ui.controller;

import com.bahri.pmb.domain.Jawaban;
import com.bahri.pmb.domain.Kategori;
import com.bahri.pmb.domain.Soal;
import com.bahri.pmb.service.JawabanService;
import com.bahri.pmb.service.KategoriService;
import com.bahri.pmb.service.SoalService;
import com.bahri.pmb.service.editor.JawabanEditor;
import com.bahri.pmb.service.editor.KategoriEditor;
import com.bahri.pmb.service.editor.SoalEditor;
import com.bahri.pmb.simple.SimpleSoal;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * User: latief
 * Date: 3/19/12
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "soal")
public class SoalController {

    @Autowired
    @Qualifier("soalService")
    private SoalService soalService;

    @Autowired
    @Qualifier("jawabanService")
    private JawabanService jawabanService;

    @Autowired
    @Qualifier("kategoriService")
    private KategoriService kategoriService;

    @RequestMapping(value = "navbar", method = RequestMethod.GET)
    public String navBar() {
        return "soal/navbar";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String find(ModelMap modelMap, @RequestParam(required = false, value = "page", defaultValue = "1") int page, @RequestParam(required = false, value = "max", defaultValue = "0")int max) {
        modelMap.addAttribute("soals", soalService.findSoals());
        return "soal/list";
    }

    @RequestMapping(params = "id", method = RequestMethod.GET)
    public String find(ModelMap modelMap, @RequestParam("id") Soal soal) {
        modelMap.addAttribute("event", "DETAIL");
        modelMap.addAttribute("soal", soal);
        return "soal/input";
    }

    @RequestMapping(params = "id", method = RequestMethod.DELETE)
    public @ResponseBody String delete(@RequestParam("id") Soal soal) {
        try{
            soalService.delete(soal);
            return "Sukses";
        }catch (HibernateException e){
            return "Gagal";
        }
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        modelMap.addAttribute("event", "INPUT");
        modelMap.addAttribute("httpMethod", "POST");
        modelMap.addAttribute("kategoriList",kategoriService.findKategoris());
        modelMap.addAttribute("soal", new SimpleSoal());

//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            modelMap.addAttribute("soalJson", objectMapper.writeValueAsString(new Soal()));
//        } catch (IOException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
        return "soal/input";
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String save(@Valid @ModelAttribute("soal") SimpleSoal soal, BindingResult bindingResult, ModelMap modelMap){
        if(soal == null) return "Gagal";
        if(bindingResult.hasErrors()) return "Gagal";

        try{
              // soalService.save(soal.convertToSoal());
            return "Sukses";
        }catch (HibernateException e){
            return "Gagal";
        }
    }

    @RequestMapping(method = RequestMethod.POST, headers = {"content-type=application/json"})
    public
    @ResponseBody
    String save(@RequestBody Soal soal) {
        System.out.println(soal);
        if (soal == null) return "Gagal";

        try {
           soalService.save(soal);
            return "Sukses";
        } catch (HibernateException e) {
            return "Gagal";
        }
    }

    @RequestMapping(value = "edit", params = "id", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, @RequestParam("id")Soal soal) {

        modelMap.addAttribute("event", "EDIT");
        modelMap.addAttribute("httpMethod", "PUT");
        modelMap.addAttribute("soal", soal);
        return "soal/input";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody String update(@Valid @ModelAttribute("soal") Soal soal, BindingResult bindingResult, ModelMap modelMap){

        if(soal == null) return "Gagal";
        if(bindingResult.hasErrors()) return "Gagal";

        try{
            soalService.save(soal);
            return "Sukses";
        }catch (HibernateException e){
            return "Gagal";
        }
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String formSearch(ModelMap modelMap) {
        modelMap.addAttribute("event", "SEARCH");
        modelMap.addAttribute("httpMethod", "POST");
        modelMap.addAttribute("soal", new Soal());
        return "soal/input";
    }

    @RequestMapping(value="search",method = RequestMethod.POST)
    public String search(@Valid @ModelAttribute("soal") Soal soal, BindingResult bindingResult, ModelMap modelMap){

        //List<Soal> listSoal=transaksiService.findSoals(soal);
      //  modelMap.addAttribute("soals", listSoal);
        return "soal/list";
    }



    @InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception{
        binder.registerCustomEditor(Soal.class, new SoalEditor(soalService));
        binder.registerCustomEditor(Kategori.class, new KategoriEditor(kategoriService));
        binder.registerCustomEditor(Jawaban.class,new JawabanEditor(jawabanService));

    }
}
