package com.taiton.service;

import com.taiton.dao.AccountDao;
import com.taiton.dao.OrganizationDao;
import com.taiton.entity.AccountEntity;
import com.taiton.entity.OrganizationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taiton on 1/2/2017.
 */
@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationDao organizationDao;

    @Override
    public List<OrganizationEntity> findAll() {
        return organizationDao.findAll();
    }

    @Override
    public OrganizationEntity find(int id) {
        return organizationDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        organizationDao.delete(id);
    }

    @Override
    public void save(OrganizationEntity organizationEntity) {
        organizationDao.save(organizationEntity);
    }

    @Override
    public OrganizationEntity findByName(String name) {
        return organizationDao.findByName(name);
    }

    @Override
    public List<OrganizationEntity> findByCategory(int idCategory) {

        return organizationDao.findByCategory(idCategory);
    }
}
