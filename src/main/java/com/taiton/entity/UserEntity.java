package com.taiton.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.taiton.jsonConverter.UserDeserializer;

import javax.persistence.*;

/**
 * Created by VitalitY on 14.12.2016.
 */

@Entity
@Table(name = "user", schema = "heroku_379802575654769", catalog = "")
public class UserEntity {
    private int id;
    private String username;
    private String password;
    private boolean isBlocked;
    private RoleEntity roleByRoleIdRole;
    @JsonIgnore
    private transient String confirmPassword;

    @Transient
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "IsBlocked")
    public boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (isBlocked != that.isBlocked) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Role_idRole", referencedColumnName = "Id", nullable = false)
    public RoleEntity getRoleByRoleIdRole() {
        return roleByRoleIdRole;
    }

    public void setRoleByRoleIdRole(RoleEntity roleByRoleIdRole) {
        this.roleByRoleIdRole = roleByRoleIdRole;
    }
}
