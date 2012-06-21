package com.bahri.pmb.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(ModelMap modelMap){
        return "login-admin";
    }

    @RequestMapping(value = "dashboard", method = RequestMethod.GET)
    public String dashboard(ModelMap modelMap){
        return "dashboard-page";
    }
}