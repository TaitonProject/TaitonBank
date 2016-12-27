package com.taiton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by egordragun on 25.12.16.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/users")
    public String getUsersPage() {
        return "user/users";
    }
}
