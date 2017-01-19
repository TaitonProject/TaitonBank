package com.taiton.service;

import com.taiton.dao.CategoryDao;
import com.taiton.dao.OrganizationDao;
import com.taiton.entity.CategoryEntity;
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
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<CategoryEntity> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public CategoryEntity find(int id) {
        return categoryDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }

    @Override
    public void save(CategoryEntity categoryEntity) {
        categoryDao.save(categoryEntity);
    }

    @Override
    public CategoryEntity findByCategoryName(String name) {
        CategoryEntity g = categoryDao.findByCategoryName(name);
        return g;
    }

}
