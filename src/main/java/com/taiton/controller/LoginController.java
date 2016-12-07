package com.taiton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Taiton on 12/7/2016.
 */
@Controller
public class LoginController {

    //это был метод get
    @RequestMapping(value = {"/login", "/"})
    public String login(Model model, String error, String logout) {
        /*if (error != null)
            model.addAttribute("error", "Username or password is incorrect.");
        if (logout != null)
            model.addAttribute("message", "Logged out successfully.");*/
        return "login/login";
    }
}
