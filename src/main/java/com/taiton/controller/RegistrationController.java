package com.taiton.controller;

import com.taiton.entity.UserEntity;
import com.taiton.service.SecurityService;
import com.taiton.service.UserService;
import com.taiton.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Taiton on 12/1/2016.
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", new UserEntity());
        return "registration/registration2";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") UserEntity user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration/registration2";
        }
        userService.save(user);
        securityService.autoLogin(user.getUsername(), user.getConfirmPassword());
        return "redirect:/registrationDone";
    }
}
