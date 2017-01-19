package com.taiton.dao;

import com.taiton.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Taiton on 11/23/2016.
 */
public interface ServiceDao extends JpaRepository<ServiceEntity, Integer> {

    ServiceEntity findByCategoryIdCategory(int categoryId);


    @Override
    void delete(Integer integer);
}
