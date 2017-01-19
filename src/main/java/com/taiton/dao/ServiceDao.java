package com.taiton.dao;

import com.taiton.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Taiton on 11/23/2016.
 */
public interface ServiceDao extends JpaRepository<ServiceEntity, Integer> {

    ServiceEntity findByCategoryIdCategory(int categoryId);

    @Query("select a from ServiceEntity a where a.organizationId = ?1 and a.categoryIdCategory = ?2")
    ServiceEntity findByOrganizationAndCategory(int idOrganization, int idCategory);

    @Override
    void delete(Integer integer);
}
