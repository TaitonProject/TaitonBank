package com.taiton.service;

import com.taiton.entity.RoleEntity;

import java.util.List;

/**
 * Created by Taiton on 1/2/2017.
 */
public interface RoleService {
    List<RoleEntity> findAll();

    RoleEntity find(int id);
}
