package com.taiton.dao;

import com.taiton.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Taiton on 11/23/2016.
 */
public interface RoleDao extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findByNameRole(String name);

    @Override
    void delete(Integer integer);

    @Query("select a from RoleEntity a where a.nameRole <> ?1")
    List<RoleEntity> findWithoutRole(String role);
}
