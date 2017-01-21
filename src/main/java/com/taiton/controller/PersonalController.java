package com.taiton.controller;

import com.taiton.entity.RoleEntity;
import com.taiton.entity.UserEntity;
import com.taiton.entity.UserInfoEntity;
import com.taiton.service.RoleService;
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
@RequestMapping("/personal")
public class PersonalController {

    final static String ROLE_CLIENT = "ROLE_Client";
    final static String ROLE_OPERATOR = "ROLE_Operator";
    final static String ROLE_ADMIN = "ROLE_Administration";

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/registration")
    public String getRegistrationPage() {
        return "personal/registration";
    }

    @RequestMapping("/editing")
    public String getEditingPage() {
        return "personal/editing";
    }

    @GetMapping("/rolesList.json")
    public @ResponseBody ResponseEntity<List<RoleEntity>> getRolesList(){
        if (roleService.findWithoutRole(ROLE_CLIENT) != null){
            return new ResponseEntity<>(roleService.findWithoutRole(ROLE_CLIENT), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/personalsList.json")
    public @ResponseBody ResponseEntity<List<UserInfoEntity>> getListPersonals(){
        if (userInfoService.findWithoutRole(ROLE_CLIENT) != null){
            return new ResponseEntity<>(userInfoService.findWithoutRole(ROLE_CLIENT), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @PostMapping("/addUser")
    public @ResponseBody ResponseEntity<String> registeredUser(@RequestBody UserInfoEntity userInfo, BindingResult bindingResult) {
        try { if (userInfoService.findByPasportNumber(userInfo.getPasportNumber()) != null) {
                return new ResponseEntity<>(" Пользователь с такими паспортными данными уже существует.", HttpStatus.BAD_REQUEST);
            } else if (userInfo.getUserByUserId().getRoleByRoleIdRole() == null) {
                return new ResponseEntity<>(" Не выбрана роль пользователя.", HttpStatus.BAD_REQUEST);
            } else if (userInfo.getFirstName() == null || userInfo.getSecondName() == null || userInfo.getSurName() == null || userInfo.getPasportNumber() == null) {
                return new ResponseEntity<>(" Не все поля заполнены.", HttpStatus.BAD_REQUEST);
            } else {
                int j = 10;
                //Устанавливаем роль пользоватлея
                userInfo.getUserByUserId().setRoleByRoleIdRole(userInfo.getUserByUserId().getRoleByRoleIdRole());
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

    @Transactional
    @PutMapping("/editUser")
    public @ResponseBody ResponseEntity<String> editUser(@RequestBody UserInfoEntity userInfo) {
        try { if (userInfoService.findByPasportNumber(userInfo.getPasportNumber()) != null) {
                return new ResponseEntity<>(" Пользователь с такими паспортными данными уже существует.", HttpStatus.BAD_REQUEST);
            } else if (userInfo.getFirstName() == null || userInfo.getSecondName() == null || userInfo.getSurName() == null || userInfo.getPasportNumber() == null) {
                return new ResponseEntity<>(" Не все поля заполнены.", HttpStatus.BAD_REQUEST);
            } else {
                int i = 0;
                //Устанавливаем роль пользоватлея
                //userInfo.getUserByUserId().setRoleByRoleIdRole(userInfo.getUserByUserId().getRoleByRoleIdRole());
                //userService.save(userInfo.getUserByUserId());
                // Присваиваем информации пользователя самого пользователя, всунув id пользователя из БД
                userInfo.getUserByUserId().setId(userService.findByUsername(userInfo.getUserByUserId().getUsername()).getId());
                userInfoService.save(userInfo);
                return new ResponseEntity<>(" Пользователь успешно отредактирован.", HttpStatus.OK);
            }
        } catch (Exception e){
            return new ResponseEntity<>(" Некорректный ввод. Попробуйте еще раз.", HttpStatus.BAD_REQUEST);
        }
    }

}
