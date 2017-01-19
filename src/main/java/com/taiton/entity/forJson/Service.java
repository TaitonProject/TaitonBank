package com.taiton.entity.forJson;

import com.taiton.entity.CategoryEntity;

/**
 * Created by Taiton on 1/16/2017.
 */
public class Service {
    private int account;
    private int organizationId;
    private CategoryEntity categoryIdCategory;

    public Service( int account, int organizationId, CategoryEntity categoryEntity) {
        this.account = account;
        this.organizationId = organizationId;
        this.categoryIdCategory = categoryEntity;
    }

    public Service() {
    }


    public CategoryEntity getCategoryIdCategory() {
        return categoryIdCategory;
    }

    public void setCategoryIdCategory(CategoryEntity categoryEntity) {
        this.categoryIdCategory = categoryEntity;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }
}
