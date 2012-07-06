package com.bahri.pmb.ui.controller;

import com.bahri.pmb.domain.Kategori;
import com.bahri.pmb.domain.Ujian;
import com.bahri.pmb.service.KategoriService;
import com.bahri.pmb.service.UjianService;
import com.bahri.pmb.service.editor.KategoriEditor;
import com.bahri.pmb.service.editor.UjianEditor;
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
@RequestMapping(value = "hasilUjian")
public class HasilUjianController {

    @Autowired
    @Qualifier("ujianService")
    private UjianService ujianService;

    @RequestMapping(value = "navbar", method = RequestMethod.GET)
    public String navBar() {
        return "hasil/navbar";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String find(ModelMap modelMap, @RequestParam(required = false, value = "page", defaultValue = "1") int page) {
        modelMap.addAttribute("hasils", ujianService.findUjians());
        return "hasil/list";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception{
        binder.registerCustomEditor(Ujian.class, new UjianEditor(ujianService));
    }
}
