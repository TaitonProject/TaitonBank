package com.taiton.controller;

import com.taiton.entity.UserEntity;
import com.taiton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by egordragun on 26.12.16.
 */
@Controller
@RequestMapping("/editing")
public class UserEditController {

    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public String getPhonePage() {
        return "editing/user";
    }

    @GetMapping("/listUsers.json")
    public @ResponseBody
    List<UserEntity> fetchListUsers(){
        return userService.findAll();
    }

}
