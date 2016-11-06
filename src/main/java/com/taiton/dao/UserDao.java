package com.taiton.dao;

import com.taiton.entity.UserEntity;

import java.util.List;

/**
 * Created by Taiton on 11/5/2016.
 */
public interface UserDao {
    void addUser(UserEntity user);
    void updateUser(UserEntity user);
    List<UserEntity> listUsers();
    UserEntity getUserById(int id);
    void removeUser(int id);
    UserEntity findByLoginAndPassword(String login, String password);
}
