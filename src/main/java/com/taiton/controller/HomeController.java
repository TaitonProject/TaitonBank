package com.taiton.controller;

import com.taiton.entity.UserEntity;
import com.taiton.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Taiton on 10/25/2016.
 */
@Controller
public class HomeController {

    private UserService userService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String login(@ModelAttribute("user")UserEntity user){
        return "login";
    }
}
