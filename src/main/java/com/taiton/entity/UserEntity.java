package com.taiton.entity;

import javax.persistence.*;

/**
 * Created by Taiton on 11/25/2016.
 */
@Entity
@Table(name = "user", schema = "ibankdb", catalog = "")
public class UserEntity {
    private Integer id;
    private String username;
    private String password;
    private Byte isBlocked;
    private RolesEntity role;
    private transient String confirmPassword;

    @Transient
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Username", nullable = true, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (isBlocked != null ? !isBlocked.equals(that.isBlocked) : that.isBlocked != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (isBlocked != null ? isBlocked.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Role_idRole", referencedColumnName = "Id", nullable = false)
    public RolesEntity getRole() {
        return role;
    }

    public void setRole(RolesEntity roleByRoleIdRole) {
        this.role = roleByRoleIdRole;
    }
}
