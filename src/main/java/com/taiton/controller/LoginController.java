package com.taiton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Taiton on 12/4/2016.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login/login";
    }

}
