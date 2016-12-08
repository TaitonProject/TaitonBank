package com.taiton.controller;

import com.taiton.entity.RolesEntity;
import com.taiton.entity.UserEntity;
import com.taiton.service.SecurityService;
import com.taiton.service.UserService;
import com.taiton.validator.RoleValidator;
import com.taiton.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

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


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", new UserEntity());
        /*Map<String, RolesEntity> roles = new HashMap<>();
        for(RolesEntity o: userService.getRolesSet())
            roles.put(o.getNameRole(), o);*/
        List<RolesEntity> roles = userService.getRolesSet();
        model.addAttribute("roles", roles);
        return "registration/registration2";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") UserEntity user, BindingResult bindingResult, @ModelAttribute("role") RolesEntity role, Model model) {
        userValidator.validate(user, bindingResult);
        user.setRole(role);
//        roleValidator.validate(role, bindingResultRole);

        if (bindingResult.hasErrors() /*|| bindingResultRole.hasErrors()*/) {
            return "registration/registration2";
        }

        userService.save(user);

        securityService.autoLogin(user.getUsername(), user.getConfirmPassword());

        return "redirect:/home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "mainAuthorization/login";
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "home/home";
    }


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin/admin";
    }
}
