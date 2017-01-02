package com.taiton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by egordragun on 26.12.16.
 */
@Controller
@RequestMapping("/phone")
public class PhoneController {
    @RequestMapping("/phone")
    public String getPhonePage() {
        return "pay/phone";
    }
}
