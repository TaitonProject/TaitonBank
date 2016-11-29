package com.taiton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Taiton on 11/27/2016.
 */
@Controller
public class RadioController {

    @RequestMapping(value = "/chooseradio", method = RequestMethod.GET)
    public String chooseradio(){
        return "radiobuttons/chooseradio";
    }

    @RequestMapping(value = "/radioresult", method = RequestMethod.POST)
    public String result(){
        return "gr";
    }
}
