package com.taiton.controller;

import com.taiton.entity.RoleEntity;
import com.taiton.entity.UserEntity;
import com.taiton.service.RoleService;
import com.taiton.service.SecurityService;
import com.taiton.service.UserService;
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

    @RequestMapping("/user")
    public String getUserRegistrationPage() {
        return "registration/user";
    }

    @GetMapping("registration.json")
    public @ResponseBody List<UserEntity> fetchListUsers(){
        return userService.findAll();
    }

    @GetMapping("listRoles.json")
    public @ResponseBody List<RoleEntity> fetchListRoles(){
        return roleService.findAll();
    }

    @PostMapping("/addUser")
    public @ResponseBody
    ResponseEntity<Void> registeredUser(@RequestBody UserEntity user, BindingResult bindingResult) {
        user.setRoleByRoleIdRole(roleService.find(1));
/*        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }*/
        userService.save(user);
//        securityService.autoLogin(user.getUsername(), user.getConfirmPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
