package com.taiton.service;

import com.taiton.dao.RoleDao;
import com.taiton.dao.UserDao;
import com.taiton.entity.RolesEntity;
import com.taiton.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Taiton on 11/6/2016.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UserEntity user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if(user.getRoleName().equals("client"))
            user.setRole(roleDao.findOne(1L));
        if(user.getRoleName().equals("operator"))
            user.setRole(roleDao.findOne(2L));
        if(user.getRoleName().equals("administration"))
            user.setRole(roleDao.findOne(3L));

//        user.setRole(roleDao.findByNameRole("ROLE_" + role));
        user.setIsBlocked((byte) 0);
        userDao.save(user);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
