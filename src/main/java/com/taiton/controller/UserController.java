package com.taiton.controller;

import com.taiton.entity.UserEntity;
import com.taiton.entity.UserInfoEntity;
import com.taiton.entity.forJson.Password;
import com.taiton.service.UserInfoService;
import com.taiton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by egordragun on 25.12.16.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/profile")
    public String getUsersPage() {
        return "user/profile";
    }

    @PutMapping("/editPassword")
    public @ResponseBody ResponseEntity<Void> editPassword(@RequestBody Password password){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.findByUsername(user.getUsername());
        userEntity.setPassword(password.getPassword());
        userService.save(userEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/hello")
    public @ResponseBody ResponseEntity<UserInfoEntity> helloUser(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.findByUsername(user.getUsername());
        UserInfoEntity userInfoEntity = userInfoService.findByUserId(userEntity.getId());
        return new ResponseEntity<>(userInfoService.findByUserId(userEntity.getId()), HttpStatus.OK);
    }

}
