package com.taiton.controller;

import com.taiton.entity.*;
import com.taiton.entity.forJson.PaymentArchive;
import com.taiton.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taiton on 1/21/2017.
 */
@Controller
@RequestMapping("/archive")
public class ArchiveController {

    @Autowired
    private CardService cardService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/payment")
    public String getPaymentArchivePage() {
        return "archive/payment";
    }

    @RequestMapping("/transfer")
    public String getPaymentTransferPage() {
        return "archive/transfer";
    }

    @GetMapping("/listPayment.json/{number}")
    public @ResponseBody List<PaymentArchive> getListPayment(@PathVariable int number) {
        CardEntity card = cardService.find(number);
        List<PaymentEntity> payments = paymentService.findByCard(number);
        List<PaymentArchive> listPayment = new ArrayList<>();
        if (card == null) {
            return null;
        } else {
            for (int i = 0; i < payments.size(); i++) {
                listPayment.add(new PaymentArchive(
                        payments.get(i),
                        categoryService.find(serviceService.find(payments.get(i).getServiceId()).getCategoryIdCategory()).getCategoryName(),
                        organizationService.find(serviceService.find(payments.get(i).getServiceId()).getOrganizationId()).getName())
                );
            }
            return listPayment;
        }
    }
}
