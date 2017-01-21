package com.taiton.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Taiton on 1/21/2017.
 */
@RequestMapping("/archive")
public class ArchiveController {

    @RequestMapping("/payment")
    public String getPaymentArchivePage(){
        return "/archive/payment";
    }

    @RequestMapping("/payment")
    public String getPaymentTransferPage(){
        return "/archive/transfer";
    }
}
