package com.taiton.dao;

import com.taiton.entity.OrganizationEntity;
import com.taiton.entity.forJson.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Taiton on 11/23/2016.
 */
public interface OrganizationDao extends JpaRepository<OrganizationEntity, Integer> {

    @Query("select a from OrganizationEntity a where a.name = ?1")
    OrganizationEntity findByName(String name);

    @Override
    void delete(Integer integer);

    @Query("select a from OrganizationEntity  a where a.id in (select s.organizationId from ServiceEntity s where s.categoryIdCategory = ?1 )")
    List<OrganizationEntity> findByCategory(int idCategory);
}
