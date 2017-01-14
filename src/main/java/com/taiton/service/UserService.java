package com.taiton.service;

import com.taiton.entity.UserEntity;

import java.util.List;

/**
 * Created by Taiton on 11/6/2016.
 */
public interface UserService {

    void save(UserEntity userEntity);

    void delete(int id);

    UserEntity findByUsername(String username);

    List<UserEntity> findAll();

    UserEntity findOne(int id);
}
