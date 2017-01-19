package com.taiton.controller;

import com.taiton.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by egordragun on 26.12.16.
 */

@Controller
@RequestMapping("/transaction")
public class TransferCardController {

    @Autowired
    private CardService cardService;

    @RequestMapping("/transferCards")
    public String getCardTransactionPage() {
        return "transaction/transferCards";
    }



}