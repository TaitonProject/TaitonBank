package com.taiton.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Taiton on 1/21/2017.
 */
@RequestMapping("/main")
public class MainController {

    @RequestMapping("/home")
    public String getMainPage(){
        return "main/home";
    }


}
