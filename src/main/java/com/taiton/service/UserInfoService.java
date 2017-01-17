package com.taiton.service;

import com.taiton.entity.UserInfoEntity;

import java.util.List;

/**
 * Created by Taiton on 11/6/2016.
 */
public interface UserInfoService {

    void save(UserInfoEntity userInfoEntity);

    void delete(int id);

    UserInfoEntity findOne(int id);

    List<UserInfoEntity> findAll();

    UserInfoEntity findByPasportNumber(String pasportNumber);

}
