package com.taiton.dao;

import com.taiton.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Taiton on 11/23/2016.
 */
public interface OrganizationDao extends JpaRepository<OrganizationEntity, Integer> {

    OrganizationEntity findByName(String name);

    @Override
    void delete(Integer integer);
}
