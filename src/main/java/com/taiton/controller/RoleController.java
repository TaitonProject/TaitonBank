package com.taiton.controller;

import com.taiton.dao.RoleDao;
import com.taiton.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taiton on 12/7/2016.
 */
@Controller
public class RoleController {

    @Autowired
    RoleDao roleDao;

    @RequestMapping(value = "/listRoles", method = RequestMethod.GET)
    public String admin() {
        return "listRoles/listRoles";
    }

/*    @RequestMapping(value = "listRoles.json")
    public @ResponseBody List<RoleEntity> getRolePage(){
        return roleDao.findAll();
    }*/

    @RequestMapping(value = "listRoles.json")
    public @ResponseBody ResponseEntity getRolePage(){
        return new ResponseEntity(roleDao.findAll(), HttpStatus.OK);
    }
}
