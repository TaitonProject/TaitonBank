package com.taiton.service;

import com.taiton.entity.UserEntity;

/**
 * Created by Taiton on 11/6/2016.
 */
public interface UserService {

    void save(UserEntity userEntity);

    UserEntity findByUsername(String username);

}
