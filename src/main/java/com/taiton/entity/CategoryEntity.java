package com.taiton.entity;

import javax.persistence.*;

/**
 * Created by Taiton on 1/19/2017.
 */
@Entity
@Table(name = "category", schema = "heroku_379802575654769", catalog = "")
public class CategoryEntity {
    private Integer idCategory;
    private String categoryName;

    @Id
    @Column(name = "idCategory", nullable = false)
    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    @Basic
    @Column(name = "Category_Name", nullable = false, length = 45)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (idCategory != null ? !idCategory.equals(that.idCategory) : that.idCategory != null) return false;
        if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCategory != null ? idCategory.hashCode() : 0;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        return result;
    }
}
