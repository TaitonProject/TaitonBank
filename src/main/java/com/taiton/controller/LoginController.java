package com.taiton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Taiton on 12/4/2016.
 */
@Controller
public class LoginController {

    @RequestMapping("/login.html")
    public String login() {
        return "mainAuthorization/login";
    }

/*    // Login form with error
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }*/
}
