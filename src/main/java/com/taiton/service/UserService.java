package com.taiton.service;

import com.taiton.entity.RolesEntity;
import com.taiton.entity.UserEntity;

import java.util.List;
import java.util.Set;

/**
 * Created by Taiton on 11/6/2016.
 */
public interface UserService {

    void save(UserEntity userEntity);

    UserEntity findByUsername(String username);

    List<RolesEntity> getRolesSet();

}
