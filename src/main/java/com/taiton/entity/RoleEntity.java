package com.taiton.entity;

import javax.persistence.*;

/**
 * Created by VitalitY on 14.12.2016.
 */
@Entity
@Table(name = "role", schema = "heroku_379802575654769", catalog = "")
public class RoleEntity {
    private int id;
    private String nameRole;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name_Role")
    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (id != that.id) return false;
        if (nameRole != null ? !nameRole.equals(that.nameRole) : that.nameRole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameRole != null ? nameRole.hashCode() : 0);
        return result;
    }
}
