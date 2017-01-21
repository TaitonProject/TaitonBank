package com.taiton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Taiton on 12/4/2016.
 */
@Controller
public class LoginController {

    @RequestMapping({"/login", "/"})
    public String login() {
        return "login/login";
    }

    @RequestMapping("/loginError")
    public String loginError(){
        return "login/loginError";
    }
}
