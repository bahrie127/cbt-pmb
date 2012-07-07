package com.bahri.pmb.ui.controller;

import com.bahri.pmb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/18/12
 * Time: 11:14 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController {

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
    @Qualifier("userService")
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(ModelMap modelMap){
        return "login-admin";
    }

    @RequestMapping(value = "dashboard", method = RequestMethod.GET)
    public String dashboard(ModelMap modelMap,Principal principal){
        
        String name=principal.getName();
        modelMap.addAttribute("username",name);
        modelMap.addAttribute("message","sukses");
        modelMap.addAttribute("jumlahSoal",soalService.countSoals());
        modelMap.addAttribute("jumlahKategori",kategoriService.countKategoris());
        modelMap.addAttribute("jumlahUjian",ujianService.countUjians());
        modelMap.addAttribute("jumlahAdmin",userService.countUsers());
        modelMap.addAttribute("jumlahSoalDitampilkan",settingService.getSetting().getJumlahSoalTampil());
        modelMap.addAttribute("waktuPengerjaan",settingService.getSetting().getWaktuPengerjaan());
        return "dashboard-page";
    }

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {

        model.addAttribute("paramError", "error");
        return "login-admin";

    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {

        return "login-admin";

    }
}
