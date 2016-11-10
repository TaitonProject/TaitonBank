package com.taiton.service;

import com.taiton.dao.UserDao;
import com.taiton.entity.RoleEntityEnum;
import com.taiton.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Taiton on 11/6/2016.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UserEntity user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(RoleEntityEnum.client);
        user.setIsBlocked((byte) 0);
        userDao.save(user);
    }

    @Override
    public UserEntity findByLogin(String login) {
        return userDao.findByLogin(login);
    }
}
