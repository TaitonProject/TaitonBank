package com.taiton.dao;

import com.taiton.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Created by Taiton on 11/5/2016.
 */
public interface UserInfoDao extends JpaRepository<UserInfoEntity, Integer>{
    @Override
    void delete(Integer integer);

    UserInfoEntity findByPasportNumber(String pasportNumber);

    @Query("select a from UserInfoEntity a where a.userByUserId.roleByRoleIdRole.nameRole <> ?1")
    List<UserInfoEntity> findWithoutRole(String role);

    @Query("select a from UserInfoEntity a where a.userByUserId.roleByRoleIdRole.nameRole = ?1")
    List<UserInfoEntity> findByUserRole(String role);

    @Query("select a from UserInfoEntity a where a.userByUserId.id = ?1")
    UserInfoEntity findByUserId(int userId);

}
