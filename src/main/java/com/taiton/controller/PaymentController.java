package com.taiton.controller;

import com.taiton.entity.*;
import com.taiton.entity.forJson.PaymentInfo;
import com.taiton.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/service")
    public String getPaymentServicePage() {
        return "payment/service";
    }

    @PostMapping("/addPayment")
    public @ResponseBody
    ResponseEntity<Void> addPayment(@RequestBody PaymentInfo paymentInfo){
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setAmount(paymentInfo.getPayment().getAmount());
        paymentEntity.setCardId(cardService.findByCardNumber(paymentInfo.getCard().getCardNumber()).getId());
        paymentEntity.setInfo(paymentInfo.getPayment().getInfo());
        paymentEntity.setServiceId(serviceService.findByOrganizationAndCategory(paymentInfo.getOrganization().getId(), paymentInfo.getCategory().getIdCategory()).getId());
        //paymentEntity.setServiceId(paymentInfo.set);
        if(accountService.find(cardService.find(paymentEntity.getCardId()).getAccountId()).getAccountBalance() >= paymentEntity.getAmount()){
            paymentEntity.setDate(new Timestamp(System.currentTimeMillis()));
            paymentService.save(paymentEntity);
            AccountEntity accountEntity = accountService.find(paymentInfo.getCard().getAccountId());
            double currentBalance =  accountEntity.getAccountBalance() - paymentEntity.getAmount();
            accountEntity.setAccountBalance(currentBalance);
            accountService.save(accountEntity);
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

    @GetMapping("/cardList.json")
    public @ResponseBody
    ResponseEntity fetchListCard(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity<>(cardService.findByUser(userService.findByUsername(user.getUsername()).getId()), HttpStatus.OK);
    }

    @GetMapping("/hello")
    public @ResponseBody ResponseEntity<UserInfoEntity> helloUser(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.findByUsername(user.getUsername());
        //UserInfoEntity userInfoEntity = userInfoService.findByUserId(userEntity.getId());


        return new ResponseEntity<>(userInfoService.findByUserId(userEntity.getId()), HttpStatus.OK);
    }

}
