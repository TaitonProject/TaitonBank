package com.taiton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by egordragun on 26.12.16.
 */
@Controller
@RequestMapping("/tranzactions")
public class TransferCardController {
    @RequestMapping("/transferCards")
    public String getPhonePage() {
        return "tranzactions/transferCards";
    }
}