package com.bahri.pmb.ui.controller;

import com.bahri.pmb.domain.PengerjaanSoal;
import com.bahri.pmb.domain.Ujian;
import com.bahri.pmb.service.PengerjaanSoalService;
import com.bahri.pmb.service.UjianService;
import com.bahri.pmb.service.editor.PengerjaanSoalEditor;
import com.bahri.pmb.service.editor.UjianEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @Qualifier("pengerjaanSoalService")
    private PengerjaanSoalService pengerjaanSoalService;

    @RequestMapping(value = "mulai",method = RequestMethod.GET)
    public String ujianMulai(ModelMap modelMap){
        modelMap.addAttribute("ujians",ujianService.findUjians());
        return "cbt-page";
    }
    
    
    
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception{
        binder.registerCustomEditor(Ujian.class, new UjianEditor(ujianService));
        binder.registerCustomEditor(PengerjaanSoal.class,new PengerjaanSoalEditor(pengerjaanSoalService));
    }
}
