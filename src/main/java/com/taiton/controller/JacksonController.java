package com.taiton.controller;

import com.taiton.dao.UserDao;
import com.taiton.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Taiton on 12/11/2016.
 */
@Controller
public class JacksonController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/listUsers")
    public ResponseEntity getUserList(){
        List<UserEntity> userEntityList = userDao.findAll();
        if(userEntityList.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(userEntityList, HttpStatus.OK);
    }
}
