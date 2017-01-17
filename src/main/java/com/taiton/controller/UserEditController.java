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
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by egordragun on 26.12.16.
 */
@Controller
@RequestMapping("/editing")
public class UserEditController {

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
    public @ResponseBody List<UserInfoEntity> fetchListUsers() {
        return userInfoService.findAll();
    }

    @PutMapping("/editUser")
    public @ResponseBody ResponseEntity<Void> editUser(@RequestBody UserInfoEntity userInfo) {
        userInfoService.save(userInfo);
        return new ResponseEntity<>(HttpStatus.OK);
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
    public @ResponseBody ResponseEntity<Void> addUserBalance(@RequestBody UserBalance userBalance) {
        AccountEntity accountEntity = accountService.findByAccountNumber(userBalance.getAccountNumber());
        if (accountEntity != null) {
            //double accountBalance = Math.abs(userBalance.getAccountBalance());
            accountEntity.setAccountBalance(accountEntity.getAccountBalance() + userBalance.getAccountBalance());
            accountService.save(accountEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
