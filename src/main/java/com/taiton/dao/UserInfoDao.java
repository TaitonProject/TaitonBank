package com.taiton.dao;

import com.taiton.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Taiton on 11/5/2016.
 */
public interface UserInfoDao extends JpaRepository<UserInfoEntity, Integer>{
    @Override
    void delete(Integer integer);

    UserInfoEntity findByPasportNumber(String pasportNumber);
}
