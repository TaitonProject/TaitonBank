package com.taiton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Taiton on 10/25/2016.
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getHomePage() {
        return "home/home";
    }

    @RequestMapping("/user")
    public String getUserPage(){
        return "home/user";
    }
}
