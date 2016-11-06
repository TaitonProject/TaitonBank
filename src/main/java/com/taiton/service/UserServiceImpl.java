package com.taiton.service;

import com.taiton.dao.UserDao;
import com.taiton.entity.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taiton on 11/6/2016.
 */
@Service
public class UserServiceImpl implements UserService{

    private UserDao UserDao;

    public void setUserDAO(UserDao userDAO) {
        this.UserDao = userDAO;
    }

    @Transactional
    public void addUser(UserEntity user) {
        this.UserDao.addUser(user);
    }

    @Transactional
    public void updateUser(UserEntity user) {
        this.UserDao.updateUser(user);
    }

    @Transactional
    public List<UserEntity> listUsers() {
        return this.UserDao.listUsers();
    }

    @Transactional
    public UserEntity getUserById(int id) {
        return this.UserDao.getUserById(id);
    }

    @Transactional
    public void removeUser(int id) {
        this.UserDao.removeUser(id);
    }

    public UserEntity findByLoginAndPassword(String login, String password) {
        return null;
    }
}
