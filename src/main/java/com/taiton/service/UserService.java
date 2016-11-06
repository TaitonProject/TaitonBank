package com.taiton.service;

import com.taiton.entity.UserEntity;

import java.util.List;

/**
 * Created by Taiton on 11/6/2016.
 */
public interface UserService {
    void addUser(UserEntity user);
    void updateUser(UserEntity user);
    List<UserEntity> listUsers();
    UserEntity getUserById(int id);
    void removeUser(int id);
    UserEntity findByLoginAndPassword(String login, String password);
}
