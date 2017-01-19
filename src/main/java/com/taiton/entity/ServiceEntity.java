package com.taiton.entity;

import javax.persistence.*;

/**
 * Created by VitalitY on 14.12.2016.
 */
@Entity
@Table(name = "service", schema = "heroku_379802575654769", catalog = "")
public class ServiceEntity {
    private int id;
    private Integer accountId;
    private Integer organizationId;
    private Integer categoryIdCategory;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceEntity that = (ServiceEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = id;
        return result;
    }


    @Basic
    @Column(name = "account_Id", nullable = false)
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "organization_id", nullable = false)
    public Integer getOrganizationId() {
        return organizationId;
    }
public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    @Basic
    @Column(name = "Category_idCategory", nullable = false)
    public Integer getCategoryIdCategory() {
        return categoryIdCategory;
    }

    public void setCategoryIdCategory(Integer categoryIdCategory) {
        this.categoryIdCategory = categoryIdCategory;
    }
}
