package com.taiton.service;

import com.taiton.dao.UserInfoDao;
import com.taiton.entity.UserInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taiton on 11/6/2016.
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private UserService userService;

    @Override
    public void save(UserInfoEntity userInfoEntity) {
        userInfoDao.save(userInfoEntity);
    }

    @Override
    public void delete(int id) {
        userInfoDao.delete(id);
    }

    @Override
    public UserInfoEntity findOne(int id) {
        return userInfoDao.findOne(id);
    }

    @Override
    public List<UserInfoEntity> findAll() {
        return userInfoDao.findAll();
    }

    @Override
    public UserInfoEntity findByPasportNumber(String pasportNumber) {
        return userInfoDao.findByPasportNumber(pasportNumber);
    }

    @Override
    public List<UserInfoEntity> findWithoutRole(String role) {
        return userInfoDao.findWithoutRole(role);
    }

    @Override
    public List<UserInfoEntity> findByUserRole(String role) {
        return userInfoDao.findByUserRole(role);
    }

    @Override
    public UserInfoEntity findByUserId(int userId) {
        return userInfoDao.findByUserId(userId);
    }
}
