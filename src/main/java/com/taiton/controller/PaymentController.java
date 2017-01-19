package com.taiton.controller;

import com.taiton.entity.*;
import com.taiton.entity.forJson.Organization;
import com.taiton.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by egordragun on 26.12.16.
 */
@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private CardService cardService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/service")
    public String getPaymentServicePage() {
        return "payment/service";
    }

    @PostMapping("/addPayment")
    public @ResponseBody
    ResponseEntity<Void> addPayment(@RequestBody PaymentEntity paymentEntity){

        if(accountService.find(cardService.find(paymentEntity.getCardByCardId().getId()).getAccountId()).getAccountBalance() >= paymentEntity.getAmount()){
            paymentEntity.setDate(new Timestamp(System.currentTimeMillis()));
            paymentService.save(paymentEntity);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/serviceList.json")
    public @ResponseBody
    List<ServiceEntity> fetchListService(){
        return serviceService.findAll();
    }

    @GetMapping("/accountList.json")
    public @ResponseBody
    List<AccountEntity> fetchListAccount(){
        return accountService.findAllOrganization();
    }

    @GetMapping("/organizationList.json/{idCategory}")
    public @ResponseBody
    List<OrganizationEntity> fetchListOrganization(@PathVariable int idCategory){
        List<OrganizationEntity> gg = organizationService.findByCategory(idCategory);
        return gg;
    }

    @GetMapping("/categoryList.json")
    public @ResponseBody
    List<CategoryEntity> fetchListCategory(){
        return categoryService.findAll();
    }

    @GetMapping("/cardList.json/{cardNumber}")
    public @ResponseBody
    List<CategoryEntity> fetchListCard(@PathVariable int cardNumber){
        return null;
        //return cardService.findByCardNumber(cardNumber);
    }


}
