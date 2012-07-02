package com.bahri.pmb.ui.controller;

import com.bahri.pmb.domain.Kategori;
import com.bahri.pmb.domain.Setting;
import com.bahri.pmb.service.KategoriService;
import com.bahri.pmb.service.SettingService;
import com.bahri.pmb.service.editor.KategoriEditor;
import com.bahri.pmb.service.editor.SettingEditor;
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
@RequestMapping(value = "setting")
public class SettingController {

    @Autowired
    @Qualifier("settingService")
    private SettingService settingService;

    @RequestMapping(value = "navbar", method = RequestMethod.GET)
    public String navBar() {
        return "setting/navbar";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String find(ModelMap modelMap) {
        modelMap.addAttribute("settings", settingService.getSetting());
        return "setting/list";
    }

    @RequestMapping(params = "id", method = RequestMethod.GET)
    public String find(ModelMap modelMap, @RequestParam("id") Setting setting) {
        modelMap.addAttribute("event", "DETAIL");
        modelMap.addAttribute("setting",setting);
        return "setting/input";
    }

    @RequestMapping(value = "edit", params = "id", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, @RequestParam("id")Setting setting) {

        modelMap.addAttribute("event", "EDIT");
        modelMap.addAttribute("httpMethod", "PUT");
        modelMap.addAttribute("setting",setting);
        return "setting/input";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody String update(@Valid @ModelAttribute("setting") Setting setting, BindingResult bindingResult, ModelMap modelMap){

        if(setting == null) return "Gagal";
        if(bindingResult.hasErrors()) return "Gagal";

        try{
            settingService.save(setting);
            return "Sukses";
        }catch (HibernateException e){
            return "Gagal";
        }
    }


    @InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception{
        binder.registerCustomEditor(Setting.class, new SettingEditor(settingService));
    }
}
