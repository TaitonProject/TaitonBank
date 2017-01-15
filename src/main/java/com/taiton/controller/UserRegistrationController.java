package com.taiton.controller;

import com.taiton.entity.*;
import com.taiton.entity.forJson.UserAccount;
import com.taiton.service.*;
import com.taiton.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

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
    public @ResponseBody ResponseEntity<Void> registerUserAccount(@RequestBody UserAccount account){
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUserId(account.getUserId());
        accountEntity.setAccountNumber(account.getNumber());
        accountEntity.setAccountBalance(0);
        accountService.save(accountEntity);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public @ResponseBody ResponseEntity<Void> registeredUser(@RequestBody UserInfoEntity userInfo, BindingResult bindingResult) {
        //Устанавливаем роль пользоватлея
        userInfo.getUserByUserId().setRoleByRoleIdRole(roleService.find(1));

        // Проверка валидности данных
        /*userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }*/

        userService.save(userInfo.getUserByUserId());
        // Присваиваем информации пользователя самого пользователя, всунув id пользователя из БД
        userInfo.getUserByUserId().setId(userService.findByUsername(userInfo.getUserByUserId().getUsername()).getId());
        userInfoService.save(userInfo);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
