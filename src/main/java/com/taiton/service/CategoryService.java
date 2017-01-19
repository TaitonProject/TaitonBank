package com.taiton.service;

import com.taiton.entity.CategoryEntity;
import com.taiton.entity.OrganizationEntity;

import java.util.List;

/**
 * Created by Taiton on 1/2/2017.
 */
public interface CategoryService {
    List<CategoryEntity> findAll();

    CategoryEntity find(int id);

    void delete(int id);

    void save(CategoryEntity categoryEntity);

    CategoryEntity findByCategoryName(String name);

}
