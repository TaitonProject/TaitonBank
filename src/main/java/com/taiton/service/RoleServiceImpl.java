package com.taiton.service;

import com.taiton.dao.RoleDao;
import com.taiton.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Taiton on 1/2/2017.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<RoleEntity> findAll() {
        return roleDao.findAll();
    }

    @Override
    public RoleEntity find(int id) {
        return roleDao.findOne(id);
    }
}
