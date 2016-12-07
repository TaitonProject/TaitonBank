package com.taiton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Taiton on 10/25/2016.
 */

@Controller
public class HomeController {

    //это был метод get
    @RequestMapping(value = {"/home"})
    public String welcome( Model model) {
        return "home";
    }

}
