package com.taiton.entity;

import org.hibernate.internal.util.compare.EqualsHelper;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Taiton on 11/9/2016.
 */
@Entity
@Table(name = "user", schema = "ibankdb", catalog = "")
public class UserEntity {
    private Integer id;
    private String login;
    private String password;
    private Byte isBlocked;
    private RoleEntityEnum role;
    private Collection<SessionCodeEntity> sessionCodesById;
    private Collection<SessionInformationEntity> sessionInformationsById;
    private String confirmPassword;

    @Id
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Login", nullable = false, length = 45)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "Password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "IsBlocked", nullable = false)
    public Byte getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Byte isBlocked) {
        this.isBlocked = isBlocked;
    }

    @Basic
    @Column(name = "Role", nullable = false)
    public RoleEntityEnum getRole() {
        return role;
    }

    public void setRole(RoleEntityEnum role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (isBlocked != null ? !isBlocked.equals(that.isBlocked) : that.isBlocked != null) return false;
        if (role != that.role) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (isBlocked != null ? isBlocked.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
