package com.bahri.pmb.ui.controller;

import com.bahri.pmb.domain.GradeLulus;
import com.bahri.pmb.service.GradeLulusService;
import com.bahri.pmb.service.editor.GradeLulusEditor;
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
 * To change this template use File | GradeLuluss | File Templates.
 */
@Controller
@RequestMapping(value = "grade")
public class GradeController {

    @Autowired
    @Qualifier("gradeLulusService")
    private GradeLulusService gradeLulusService;

    @RequestMapping(value = "navbar", method = RequestMethod.GET)
    public String navBar() {
        return "grade/navbar";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String find(ModelMap modelMap) {
        modelMap.addAttribute("gradeLuluss", gradeLulusService.getAllGradeLulus());
        return "grade/list";
    }

    @RequestMapping(params = "id", method = RequestMethod.GET)
    public String find(ModelMap modelMap, @RequestParam("id") GradeLulus gradeLulus) {
        modelMap.addAttribute("event", "DETAIL");
        modelMap.addAttribute("gradeLulus",gradeLulus);
        return "grade/input";
    }

    @RequestMapping(value = "edit", params = "id", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, @RequestParam("id")GradeLulus gradeLulus) {

        modelMap.addAttribute("event", "EDIT");
        modelMap.addAttribute("httpMethod", "PUT");
        modelMap.addAttribute("gradeLulus",gradeLulus);
        return "grade/input";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody String update(@Valid @ModelAttribute("gradeLulus") GradeLulus gradeLulus, BindingResult bindingResult, ModelMap modelMap){

        if(gradeLulus == null) return "Gagal";
        if(bindingResult.hasErrors()) return "Gagal";

        try{
            gradeLulusService.save(gradeLulus);
            return "Sukses";
        }catch (HibernateException e){
            return "Gagal";
        }
    }


    @InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception{
        binder.registerCustomEditor(GradeLulus.class, new GradeLulusEditor(gradeLulusService));
    }
}
