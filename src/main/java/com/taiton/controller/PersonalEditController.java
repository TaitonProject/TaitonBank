package com.taiton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by egordragun on 26.12.16.
 */
@Controller
@RequestMapping("/editing")
public class PersonalEditController {
    @RequestMapping("/personal")
    public String getPhonePage() {
        return "editing/personal";
    }
}
