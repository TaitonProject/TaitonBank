package com.taiton.service;

import com.taiton.dao.RoleDao;
import com.taiton.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taiton on 1/2/2017.
 */
@Service
@Transactional
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

    @Override
    public void delete(int id) {
        roleDao.delete(id);
    }

    @Override
    public List<RoleEntity> findWithoutRole(String role) {
        return roleDao.findWithoutRole(role);
    }
}
