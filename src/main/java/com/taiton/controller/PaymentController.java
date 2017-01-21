package com.taiton.controller;

import com.taiton.entity.*;
import com.taiton.entity.forJson.CardBalance;
import com.taiton.entity.forJson.PaymentInfo;
import com.taiton.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
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

    @Transactional
    @PostMapping("/addPayment")
    public @ResponseBody
    ResponseEntity<String> addPayment(@RequestBody PaymentInfo paymentInfo){
        try {
            PaymentEntity paymentEntity = new PaymentEntity();
            paymentEntity.setAmount(paymentInfo.getPayment().getAmount());
            paymentEntity.setCardId(cardService.findByCardNumber(paymentInfo.getCard().getCardNumber()).getId());
            paymentEntity.setInfo(paymentInfo.getPayment().getInfo());
            int service = serviceService.findByOrganizationAndCategory(paymentInfo.getOrganization().getId(), paymentInfo.getCategory().getIdCategory()).getId();

            paymentEntity.setServiceId(service);

            if (categoryService.find(paymentInfo.getCategory().getIdCategory()) == null) {
                return new ResponseEntity<>(" Данной категории не существует", HttpStatus.BAD_REQUEST);
            } else if (organizationService.find(paymentInfo.getOrganization().getId()) == null) {
                return new ResponseEntity<>(" Данной организации не существует", HttpStatus.BAD_REQUEST);
            } else if (cardService.find(paymentEntity.getCardId()) == null) {
                return new ResponseEntity<>(" Данной карты не существует", HttpStatus.BAD_REQUEST);
            } else if (paymentInfo.getPayment().getAmount() <= 0) {
                return new ResponseEntity<>(" Сумма должна быть положительным числом.", HttpStatus.BAD_REQUEST);
            } else if (accountService.find(cardService.find(paymentEntity.getCardId()).getAccountId()).getAccountBalance() < paymentEntity.getAmount()) {
                return new ResponseEntity<>(" Не хватает средств на счете.", HttpStatus.BAD_REQUEST);
            } else if (cardService.find(paymentEntity.getCardId()).getDateOfExpiry().getTime() < new Date(System.currentTimeMillis()).getTime()) {
                return new ResponseEntity<>(" Срок вашей карты истек. Обратитесь в банк.", HttpStatus.BAD_REQUEST);
            } else {
                paymentEntity.setDate(new Timestamp(System.currentTimeMillis()));
                paymentService.save(paymentEntity);
                AccountEntity accountEntity = accountService.find(paymentInfo.getCard().getAccountId());
                double currentBalance = accountEntity.getAccountBalance() - paymentEntity.getAmount();
                accountEntity.setAccountBalance(currentBalance);

                ServiceEntity servOrg = serviceService.findByOrganizationAndCategory(paymentInfo.getOrganization().getId(), paymentInfo.getCategory().getIdCategory());

                AccountEntity orgAccount = accountService.find(servOrg.getAccountId());
                double currentBalanceOrg = orgAccount.getAccountBalance() + paymentEntity.getAmount();
                orgAccount.setAccountBalance(currentBalanceOrg);
                accountService.save(orgAccount);
                accountService.save(accountEntity);
                return new ResponseEntity<>(" Платеж успешно прошел.", HttpStatus.OK);
            }
        } catch (Exception e){
            return new ResponseEntity<>(" Некорректный ввод. Попробуйте еще раз.", HttpStatus.BAD_REQUEST);
        }
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

    @GetMapping("/cardListBalance.json")
    public @ResponseBody
    ResponseEntity fetchListCardBalance(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<CardEntity> cardList = cardService.findByUser(userService.findByUsername(user.getUsername()).getId());
        List<CardBalance> cardBalanceList = new ArrayList<>();
        for (int i = 0 ; i < cardList.size(); i++){
            cardBalanceList.add(new CardBalance(cardList.get(i).getCardNumber(), accountService.find(cardList.get(i).getAccountId()).getAccountBalance()));
        }
        return new ResponseEntity<>(cardBalanceList, HttpStatus.OK);
    }

}
