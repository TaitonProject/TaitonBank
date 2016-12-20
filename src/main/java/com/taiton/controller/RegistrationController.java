package com.taiton.controller;

import com.taiton.dao.RoleDao;
import com.taiton.dao.UserDao;
import com.taiton.entity.RoleEntity;
import com.taiton.entity.UserEntity;
import com.taiton.service.SecurityService;
import com.taiton.service.UserService;
import com.taiton.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Taiton on 12/7/2016.
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    /*@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", new UserEntity());
        model.addAttribute("userList", userDao.findAll());
        model.addAttribute("roleList", roleDao.findAll());
//      model.addAttribute("role", new String());
        return "registration/layout";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") UserEntity userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration/layout";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/home";
    }*/

    @RequestMapping("/layout")
    public String getRegistrationPage() {
        return "registration/layout";
    }

    @GetMapping("registration.json")
    public @ResponseBody List<UserEntity> fetchListUsers(){
        return userDao.findAll();
    }

    @GetMapping("listRoles.json")
    public @ResponseBody List<RoleEntity> fetchListRoles(){
        return roleDao.findAll();
    }

    @PostMapping("/addUser")
    public @ResponseBody void registeredUser(@RequestBody UserEntity user) {
       /* userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration/layout";
        }*/
        userService.save(user);
        securityService.autoLogin(user.getUsername(), user.getConfirmPassword());
    }
}
