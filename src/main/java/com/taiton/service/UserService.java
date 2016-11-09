package com.taiton.service;

import com.taiton.entity.UserEntity;

import java.util.List;

/**
 * Created by Taiton on 11/6/2016.
 */
public interface UserService {

    void save(UserEntity userEntity);

    UserEntity findByLogin(String login);
}