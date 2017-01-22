package com.taiton.controller;


import com.taiton.entity.*;
import com.taiton.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

/**
 * Created by Taiton on 12/7/2016.
 */
@Controller
@RequestMapping("/card")
public class CardController {

    final static String ROLE_CLIENT = "ROLE_Client";
    final static String ROLE_OPERATOR = "ROLE_Operator";
    final static String ROLE_ADMIN = "ROLE_Administration";

    @Autowired
    private CardService cardService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/registration")
    public String getCardRegistrationPage() {
        return "card/registration";
    }

    @GetMapping("/listUsers.json")
    public
    @ResponseBody
    List<UserInfoEntity> fetchListUsers() {
        return userInfoService.findByUserRole(ROLE_CLIENT);
    }

    @GetMapping("/listUsersAccount.json/{idUser}")
    public
    @ResponseBody
    List<AccountEntity> fetchUsersAccount(@PathVariable int idUser) {
        return accountService.findByUserId(idUser);
    }

    @PostMapping("/addCard")
    public
    @ResponseBody
    ResponseEntity<String> registrationCard(@RequestBody CardEntity card) {
        try {
            if (cardService.findByCardNumber(card.getCardNumber()) != null) {
                return new ResponseEntity<>("Данная карта уже существует.", HttpStatus.BAD_REQUEST);
            } else if (card.getDateOfExpiry().getTime() < new Date(System.currentTimeMillis()).getTime()) {
                return new ResponseEntity<>("Недопустимая дата для регистрации карты. (Должна быть больше сегодняшнего числа)", HttpStatus.BAD_REQUEST);
            } else {
                cardService.save(card);
                return new ResponseEntity<>("Карта успешно добавлена", HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Некорректные данные", HttpStatus.BAD_REQUEST);
        }
    }
}
