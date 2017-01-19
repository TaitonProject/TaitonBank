package com.taiton.service;

import com.taiton.entity.OrganizationEntity;

import java.util.List;

/**
 * Created by Taiton on 1/2/2017.
 */
public interface OrganizationService {
    List<OrganizationEntity> findAll();

    OrganizationEntity find(int id);

    void delete(int id);

    void save(OrganizationEntity organizationEntity);

    OrganizationEntity findByName(String name);

    List<OrganizationEntity> findByCategory(int idCategory);

}
