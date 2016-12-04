package com.taiton.entity;

import javax.persistence.*;

/**
 * Created by Taiton on 11/25/2016.
 */
@Entity
@Table(name = "role", schema = "heroku_893975b12603774", catalog = "")
public class RolesEntity {
    private Long id;
    private String nameRole;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name_Role", nullable = false, length = 45)
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

        RolesEntity that = (RolesEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nameRole != null ? !nameRole.equals(that.nameRole) : that.nameRole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameRole != null ? nameRole.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return this.getNameRole();
    }
}
