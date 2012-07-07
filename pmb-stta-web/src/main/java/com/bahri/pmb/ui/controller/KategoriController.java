package com.bahri.pmb.ui.controller;

import com.bahri.pmb.domain.Kategori;
import com.bahri.pmb.service.KategoriService;
import com.bahri.pmb.service.editor.KategoriEditor;
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
@RequestMapping(value = "kategori")
public class KategoriController {

    @Autowired
    @Qualifier("kategoriService")
    private KategoriService kategoriService;

    @RequestMapping(value = "navbar", method = RequestMethod.GET)
    public String navBar() {
        return "kategori/navbar";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String find(ModelMap modelMap, @RequestParam(required = false, value = "page", defaultValue = "1") int page, @RequestParam(required = false, value = "max", defaultValue = "0")int max) {
        modelMap.addAttribute("kategoris", kategoriService.findKategoris());
        return "kategori/list";
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


    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String formSearch(ModelMap modelMap) {
        modelMap.addAttribute("event", "SEARCH");
        modelMap.addAttribute("httpMethod", "POST");
        modelMap.addAttribute("distributor", new Kategori());
        return "kategori/input";
    }

//    @RequestMapping(value="search",method = RequestMethod.POST)
//    public String search(@Valid @ModelAttribute("distributor") Distributor distributor, BindingResult bindingResult, ModelMap modelMap){
//
//        List<Distributor> listDistributor=distributorService.findDistributors(distributor);
//        modelMap.addAttribute("distributors", listDistributor);
//        return "distributor/list";
//    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception{
        binder.registerCustomEditor(Kategori.class, new KategoriEditor(kategoriService));
    }
}
