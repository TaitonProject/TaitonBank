package com.taiton.controller;

import com.taiton.dao.UserDao;
import com.taiton.entity.UserEntity;
import com.taiton.service.SecurityService;
import com.taiton.service.UserService;
import com.taiton.validator.RoleValidator;
import com.taiton.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taiton on 10/25/2016.
 */

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private RoleValidator roleValidator;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", new UserEntity());
        model.addAttribute("userList", userDao.findAll());
//        model.addAttribute("role", new String());
        return "registration/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") UserEntity userForm, BindingResult bindingResult,/*@ModelAttribute("userList") List<UserEntity> listUser, */Model model) {
        userValidator.validate(userForm, bindingResult);
//      roleValidator.validate(role, bindingResultRole);

        if (bindingResult.hasErrors() /*|| bindingResultRole.hasErrors()*/) {
            return "registration/registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/home";
    }

    //это был метод get
    @RequestMapping(value = {"/login", "/"})
    public String login(Model model, String error, String logout) {
        /*if (error != null)
            model.addAttribute("error", "Username or password is incorrect.");
        if (logout != null)
            model.addAttribute("message", "Logged out successfully.");*/
        return "login/login";
    }

    //это был метод get
    @RequestMapping(value = {"/home"})
    public String welcome( Model model) {
        return "home";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin/admin";
    }
}
