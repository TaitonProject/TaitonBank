package com.taiton.service.formatters;

import com.taiton.dao.RoleDao;
import com.taiton.entity.CategoryEntity;
import com.taiton.entity.RoleEntity;
import com.taiton.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Taiton on 12/8/2016.
 */
@Service
public class CategoryFormatter implements Formatter<CategoryEntity> {

    @Autowired
    CategoryService categoryService;

    @Override
    public CategoryEntity parse(String s, Locale locale) throws ParseException {
        return categoryService.findByCategoryName(s);
    }

    @Override
    public String print(CategoryEntity categoryEntity, Locale locale) {
        return (categoryEntity != null ? categoryEntity.getCategoryName() : "");
    }
}
