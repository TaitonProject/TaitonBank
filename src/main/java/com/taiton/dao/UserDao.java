package com.taiton.dao;

import com.taiton.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Taiton on 11/5/2016.
 */
public interface UserDao extends JpaRepository<UserEntity, Integer>{
    UserEntity findByLogin(String login);

}
