package com.taiton.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Taiton on 12/1/2016.
 */
@Entity
@Table(name = "user_info", schema = "heroku_303647c7ded8d0f", catalog = "")
public class UserInfoEntity {
    private Integer id;
    private String firstName;
    private String secondName;
    private String surName;
    private String pasportNumber;
    private String authority;
    private Date dateOfIssue;
    private Integer userId;
    private UserEntity userByUserId;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "First_Name", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "Second_Name", nullable = false, length = 45)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "Sur_Name", nullable = false, length = 45)
    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Basic
    @Column(name = "Pasport_Number", nullable = false, length = 45)
    public String getPasportNumber() {
        return pasportNumber;
    }

    public void setPasportNumber(String pasportNumber) {
        this.pasportNumber = pasportNumber;
    }

    @Basic
    @Column(name = "Authority", nullable = false, length = 45)
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Basic
    @Column(name = "Date_Of_Issue", nullable = false)
    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    @Basic
    @Column(name = "user_Id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfoEntity that = (UserInfoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (secondName != null ? !secondName.equals(that.secondName) : that.secondName != null) return false;
        if (surName != null ? !surName.equals(that.surName) : that.surName != null) return false;
        if (pasportNumber != null ? !pasportNumber.equals(that.pasportNumber) : that.pasportNumber != null)
            return false;
        if (authority != null ? !authority.equals(that.authority) : that.authority != null) return false;
        if (dateOfIssue != null ? !dateOfIssue.equals(that.dateOfIssue) : that.dateOfIssue != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (surName != null ? surName.hashCode() : 0);
        result = 31 * result + (pasportNumber != null ? pasportNumber.hashCode() : 0);
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        result = 31 * result + (dateOfIssue != null ? dateOfIssue.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_Id", referencedColumnName = "Id", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
}
