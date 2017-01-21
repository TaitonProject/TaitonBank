package com.taiton.controller;

import com.taiton.entity.*;
import com.taiton.entity.forJson.UserAccount;
import com.taiton.service.*;
import com.taiton.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Taiton on 12/7/2016.
 */
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/userInfo")
    public String getUserRegistrationPage() {
        return "registration/userInfo";
    }

    @GetMapping("registration.json")
    public @ResponseBody List<UserEntity> fetchListUsers(){
        return userService.findAll();
    }

    @GetMapping("listRoles.json")
    public @ResponseBody List<RoleEntity> fetchListRoles(){
        return roleService.findAll();
    }

    @GetMapping("/userAccount")
    public String getRegistrationUserAccountPage() {
        return "registration/userAccount";
    }

    @PostMapping("/userAccount")
    public @ResponseBody ResponseEntity<String> registerUserAccount(@RequestBody UserAccount account){
        try {
            if (accountService.findByAccountNumber(account.getNumber()) != null) {
                return new ResponseEntity<>(" Такой номер счета уже существует.", HttpStatus.BAD_REQUEST);
            } else if (userService.findOne(account.getUserId()) == null) {
                return new ResponseEntity<>(" Такого пользователя не существует.", HttpStatus.BAD_REQUEST);
            } else {
                AccountEntity accountEntity = new AccountEntity();
                accountEntity.setUserId(account.getUserId());
                accountEntity.setAccountNumber(account.getNumber());
                accountEntity.setAccountBalance(0);
                accountService.save(accountEntity);
                return new ResponseEntity<>(" Счет успешно добавлен.", HttpStatus.OK);
            }
        } catch (Exception e){
            return new ResponseEntity<>(" Некорректные данные.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addUser")
    public @ResponseBody ResponseEntity<String> registeredUser(@RequestBody UserInfoEntity userInfo, BindingResult bindingResult) {
        try {
            if (userService.findByUsername(userInfo.getUserByUserId().getUsername()) != null) {
                return new ResponseEntity<>(" Пользователь с таким логином уже существует.", HttpStatus.BAD_REQUEST);
            } else if (userInfoService.findByPasportNumber(userInfo.getPasportNumber()) != null) {
                return new ResponseEntity<>(" Пользователь с такими паспортными данными уже существует.", HttpStatus.BAD_REQUEST);
            } else if (userInfo.getFirstName() == null || userInfo.getSecondName() == null || userInfo.getSurName() == null || userInfo.getPasportNumber() == null) {
                return new ResponseEntity<>(" Не все поля заполнены.", HttpStatus.BAD_REQUEST);
            } else {
                //Устанавливаем роль пользоватлея
                userInfo.getUserByUserId().setRoleByRoleIdRole(roleService.find(1));
                userService.save(userInfo.getUserByUserId());
                // Присваиваем информации пользователя самого пользователя, всунув id пользователя из БД
                userInfo.getUserByUserId().setId(userService.findByUsername(userInfo.getUserByUserId().getUsername()).getId());
                userInfoService.save(userInfo);
                return new ResponseEntity<>(" Пользователь успешно зарегестрирован.", HttpStatus.OK);
            }
        } catch (Exception e){
            return new ResponseEntity<>(" Некорректный ввод. Попробуйте еще раз.", HttpStatus.BAD_REQUEST);
        }
    }
}
