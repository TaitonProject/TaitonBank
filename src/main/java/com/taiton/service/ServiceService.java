package com.taiton.service;

import com.taiton.entity.CategoryEntity;
import com.taiton.entity.ServiceEntity;

import java.util.List;

/**
 * Created by Taiton on 1/2/2017.
 */
public interface ServiceService {
    List<ServiceEntity> findAll();

    ServiceEntity find(int id);

    void delete(int id);

    void save(ServiceEntity serviceEntity);

    ServiceEntity findByCategoryIdCategory(int categoryId);
}
