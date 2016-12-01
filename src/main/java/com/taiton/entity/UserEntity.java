package com.taiton.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Taiton on 12/1/2016.
 */
@Entity
@Table(name = "user", schema = "heroku_303647c7ded8d0f", catalog = "")
public class UserEntity {
    private Integer id;
    private String username;
    private String password;
    private transient String confirmPassword;
    private Integer roleIdRole;
    private Byte isBlocked;
    private Collection<AccountEntity> accountsById;
    private Collection<SessionCodeEntity> sessionCodesById;
    private Collection<SessionInformationEntity> sessionInformationsById;
    private RoleEntity roleByRoleIdRole;
    private Collection<UserInfoEntity> userInfosById;

    @Id
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Transient
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Basic
    @Column(name = "Username", nullable = false, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "Password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Role_idRole", nullable = false)
    public Integer getRoleIdRole() {
        return roleIdRole;
    }

    public void setRoleIdRole(Integer roleIdRole) {
        this.roleIdRole = roleIdRole;
    }

    @Basic
    @Column(name = "IsBlocked", nullable = false)
    public Byte getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Byte isBlocked) {
        this.isBlocked = isBlocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (roleIdRole != null ? !roleIdRole.equals(that.roleIdRole) : that.roleIdRole != null) return false;
        if (isBlocked != null ? !isBlocked.equals(that.isBlocked) : that.isBlocked != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (roleIdRole != null ? roleIdRole.hashCode() : 0);
        result = 31 * result + (isBlocked != null ? isBlocked.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<AccountEntity> getAccountsById() {
        return accountsById;
    }

    public void setAccountsById(Collection<AccountEntity> accountsById) {
        this.accountsById = accountsById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<SessionCodeEntity> getSessionCodesById() {
        return sessionCodesById;
    }

    public void setSessionCodesById(Collection<SessionCodeEntity> sessionCodesById) {
        this.sessionCodesById = sessionCodesById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<SessionInformationEntity> getSessionInformationsById() {
        return sessionInformationsById;
    }

    public void setSessionInformationsById(Collection<SessionInformationEntity> sessionInformationsById) {
        this.sessionInformationsById = sessionInformationsById;
    }

    @ManyToOne
    @JoinColumn(name = "Role_idRole", referencedColumnName = "Id", nullable = false)
    public RoleEntity getRoleByRoleIdRole() {
        return roleByRoleIdRole;
    }

    public void setRoleByRoleIdRole(RoleEntity roleByRoleIdRole) {
        this.roleByRoleIdRole = roleByRoleIdRole;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserInfoEntity> getUserInfosById() {
        return userInfosById;
    }

    public void setUserInfosById(Collection<UserInfoEntity> userInfosById) {
        this.userInfosById = userInfosById;
    }
}
