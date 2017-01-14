package com.taiton.controller;

import com.taiton.entity.UserInfoEntity;
import com.taiton.service.UserInfoService;
import com.taiton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    UserInfoService userInfoService;

    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public String getPhonePage() {
        return "editing/user";
    }

    @GetMapping("/listUsers.json")
    public @ResponseBody List<UserInfoEntity> fetchListUsers(){
        return userInfoService.findAll();
    }

    @PutMapping("/editUser")
    public @ResponseBody ResponseEntity<Void> editUser(@RequestBody UserInfoEntity userInfo){
        userInfoService.save(userInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public @ResponseBody ResponseEntity<Void> deleteUser(@PathVariable int id){
        userService.delete(userInfoService.findOne(id).getUserByUserId().getId());
        userInfoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
