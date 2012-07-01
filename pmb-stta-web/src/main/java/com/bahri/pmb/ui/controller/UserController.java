package com.bahri.pmb.ui.controller;

import com.bahri.pmb.domain.RequestUser;
import com.bahri.pmb.domain.RequestUserPass;
import com.bahri.pmb.domain.User;
import com.bahri.pmb.service.UserService;
import com.bahri.pmb.service.editor.UserEditor;
import org.bouncycastle.util.encoders.Hex;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.encoding.PasswordEncoder;
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
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("passwordEncoder")
    private PasswordEncoder passwordEncoder;


    @RequestMapping(value = "navbar", method = RequestMethod.GET)
    public String navBar() {
        return "user/navbar";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String find(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.findUsers());
        return "user/list";
    }

    @RequestMapping(params = "id", method = RequestMethod.GET)
    public String find(ModelMap modelMap, @RequestParam("id") User user) {

        RequestUser requestUser = new RequestUser();
        requestUser.setUsername(user.getUsername());
        requestUser.setName(user.getName());
        requestUser.setAddress(user.getAddress());
        requestUser.setEnabled(user.isEnabled());
        requestUser.setPhone1(user.getPhone1());
        requestUser.setPhone2(user.getPhone2());
        
        requestUser.setRoleName(user.getRole().getAuthority());

        modelMap.addAttribute("event", "DETAIL");
        modelMap.addAttribute("user", requestUser);
        return "user/input";
    }

    @RequestMapping(params = "id", method = RequestMethod.DELETE)
    public
    @ResponseBody
    String delete(@RequestParam("id") User user) {
        try {
            userService.delete(user);
            return "Sukses";
        } catch (HibernateException e) {
            return "Gagal";
        }
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        modelMap.addAttribute("event", "INPUT");
        modelMap.addAttribute("httpMethod", "POST");
        modelMap.addAttribute("user", new RequestUser());

        return "user/input";
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    String save(@Valid @ModelAttribute("user") RequestUser requestUser, BindingResult bindingResult, ModelMap modelMap) {

        if (requestUser == null) return "Gagal";
        if (bindingResult.hasErrors()) return "Gagal";
        if (requestUser.getPassword() == null ||  !requestUser.getPassword().equals(requestUser.getConfirmPassword())){
            return "Gagal : Password tidak sama";
        }

        //encode
        String salt = new String(Hex.encode(requestUser.getUsername().getBytes()));
        String password = passwordEncoder.encodePassword(requestUser.getPassword(), salt);

        User user = new User();
        user.setUsername(requestUser.getUsername());
        user.setPassword(password);
        user.setSalt(salt);
        user.setName(requestUser.getName());
        user.setAddress(requestUser.getAddress());
        user.setPhone1(requestUser.getPhone1());
        user.setPhone2(requestUser.getPhone2());
        user.setEnabled(requestUser.getEnabled());

        try {
           userService.save(user);
            return "Sukses";
        } catch (HibernateException e) {
            return "Gagal";
        }
    }

    @RequestMapping(value = "edit", params = "id", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, @RequestParam("id") User user) {

        RequestUser requestUser = new RequestUser();
        requestUser.setUsername(user.getUsername());
        requestUser.setName(user.getName());
        requestUser.setAddress(user.getAddress());
        requestUser.setEnabled(user.isEnabled());
        requestUser.setPhone1(user.getPhone1());
        requestUser.setPhone2(user.getPhone2());

        modelMap.addAttribute("event", "EDIT");
        modelMap.addAttribute("httpMethod", "PUT");
        modelMap.addAttribute("user", requestUser);
        return "user/input";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public
    @ResponseBody
    String update(@Valid @ModelAttribute("requestUser") RequestUser requestUser, BindingResult bindingResult, ModelMap modelMap) {

        if (requestUser == null) return "Gagal";
        if (bindingResult.hasErrors()) return "Gagal";

        User oldUser = userService.findUser(requestUser.getUsername());

        User newUser = new User();
        newUser.setUsername(requestUser.getUsername());
        newUser.setName(requestUser.getName());
        newUser.setPassword(oldUser.getPassword());
        newUser.setSalt(oldUser.getSalt());
        newUser.setAddress(requestUser.getAddress());
        newUser.setPhone1(requestUser.getPhone1());
        newUser.setPhone2(requestUser.getPhone2());
        newUser.setEnabled(requestUser.getEnabled());

        try {
            userService.update(newUser);
            return "Sukses";
        } catch (HibernateException e) {
            return "Gagal";
        }
    }

    @RequestMapping(value = "pass/edit", params = "id", method = RequestMethod.GET)
    public String editUsernamePass(ModelMap modelMap, @RequestParam("id") User user) {

        RequestUserPass requestUserPass = new RequestUserPass();
        requestUserPass.setUsername(user.getUsername());
        requestUserPass.setNewUsername(user.getUsername());

        modelMap.addAttribute("user", requestUserPass);
        return "user/edituserpass";
    }

    @RequestMapping(value = "pass", method = RequestMethod.PUT)
    public
    @ResponseBody
    String updateUsernamePass(@Valid @ModelAttribute("requestUser") RequestUserPass requestUserPass, BindingResult bindingResult, ModelMap modelMap) {

        if (requestUserPass == null) return "Gagal";
        if (bindingResult.hasErrors()) return "Gagal";
        if (requestUserPass.getNewUsername() == null || requestUserPass.getNewUsername().isEmpty()){
            return "Gagal : Username baru tidak boleh kosong";
        }
        if (requestUserPass.getNewPassword() == null || !requestUserPass.getNewPassword().equals(requestUserPass.getConfirmNewPassword())){
            return "Gagal : Password baru tidak sama";
        }

        //encode
        String newSalt = null;
        String newPassword = null;
        if (requestUserPass.getNewPassword() != null && !requestUserPass.getNewPassword().isEmpty()){
            newSalt = new String(Hex.encode(requestUserPass.getUsername().getBytes()));
            newPassword = passwordEncoder.encodePassword(requestUserPass.getNewPassword(), newSalt);
        }

        try {
            userService.update(requestUserPass.getUsername(), requestUserPass.getNewUsername(), newPassword, newSalt);
            return "Sukses";
        } catch (HibernateException e) {
            return "Gagal";
        }
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(User.class, new UserEditor(userService));
    }
}
