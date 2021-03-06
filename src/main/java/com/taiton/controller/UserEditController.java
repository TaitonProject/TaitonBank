package com.taiton.controller;

import com.taiton.entity.AccountEntity;
import com.taiton.entity.UserInfoEntity;
import com.taiton.entity.forJson.UserBalance;
import com.taiton.service.AccountService;
import com.taiton.service.UserInfoService;
import com.taiton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by egordragun on 26.12.16.
 */
@Controller
@RequestMapping("/editing")
public class UserEditController {

    final static String ROLE_CLIENT = "ROLE_Client";

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/userInfo")
    public String getPhonePage() {
        return "editing/userInfo";
    }

    @GetMapping("/listUsers.json")
    public
    @ResponseBody
    List<UserInfoEntity> fetchListUsers() {
        return userInfoService.findByUserRole(ROLE_CLIENT);
    }

/*    @DeleteMapping("/deleteUser/{id}")
    public @ResponseBody ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
        userInfoService.delete(id);
        userService.delete(userInfoService.findOne(id).getUserByUserId().getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

    @GetMapping("/addUserBalance")
    public String getEditUserAccountBalancePage() {
        return "editing/userAccountBalance";
    }

    @PostMapping("/addUserBalance")
    public
    @ResponseBody
    ResponseEntity<String> addUserBalance(@RequestBody UserBalance userBalance) {
        try {
            AccountEntity accountEntity = accountService.findByAccountNumber(userBalance.getAccountNumber());
            double money = 0;
            if (accountEntity != null)
                money = accountEntity.getAccountBalance() + userBalance.getAccountBalance();
            if (accountEntity == null) {
                return new ResponseEntity<>(" Такого счета не существует.", HttpStatus.BAD_REQUEST);
            } else if (money < 0) {
                return new ResponseEntity<>(" Неверные данные. Баланс счета должен оставаться неотрицательным числом. " +
                        "Сейчас баланс данного счета составляет " + accountEntity.getAccountBalance() + " рублей", HttpStatus.BAD_REQUEST);
            } else {
                accountEntity.setAccountBalance(accountEntity.getAccountBalance() + userBalance.getAccountBalance());
                accountService.save(accountEntity);
                return new ResponseEntity<>("Средства успешно переведены. Текущий баланс счета " + accountEntity.getAccountNumber() + " составляет: " + accountEntity.getAccountBalance()  + " рублей",HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(" Некорректные данные.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/editUser")
    public
    @ResponseBody
    ResponseEntity<String> editUser(@RequestBody UserInfoEntity userInfo) {
        try {
            String oldPassportNumber = userInfoService.findOne(userInfo.getId()).getPasportNumber();
            String newPassportNumber = userInfo.getPasportNumber();

            if (oldPassportNumber.equals(newPassportNumber)) {
                //userInfo.getUserByUserId().setId(userService.findByUsername(userInfo.getUserByUserId().getUsername()).getId());
                userInfoService.save(userInfo);
                return new ResponseEntity<>(" Пользователь успешно отредактирован.", HttpStatus.OK);
            } else {
                if (userInfoService.findByPasportNumber(userInfo.getPasportNumber()) != null) {
                    int h = 0;
                    return new ResponseEntity<>(" Пользователь с такими паспортными данными уже существует.", HttpStatus.BAD_REQUEST);
                } else {
                    //userInfo.getUserByUserId().setId(userService.findByUsername(userInfo.getUserByUserId().getUsername()).getId());
                    userInfoService.save(userInfo);
                    return new ResponseEntity<>(" Пользователь успешно отредактирован.", HttpStatus.OK);
                }
            }
        } catch (Exception e) {
            return new ResponseEntity<>(" Неизвестная ошибка. Попробуйте еще раз.", HttpStatus.BAD_REQUEST);
        }
    }

}
