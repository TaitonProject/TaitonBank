package com.taiton.entity;

import javax.persistence.*;

/**
 * Created by Taiton on 10/27/2016.
 */
@Entity
@Table(name = "session_code", schema = "taitonbankdb", catalog = "")
public class SessionCodeEntity {
    private Integer idSessionCode;
    private Integer sessionCode;
    private Integer sessionCodeNumber;
    private Integer userId;
    private UserEntity userByUserId;

    @Id
    @Column(name = "Id_Session_Code", nullable = false)
    public Integer getIdSessionCode() {
        return idSessionCode;
    }

    public void setIdSessionCode(Integer idSessionCode) {
        this.idSessionCode = idSessionCode;
    }

    @Basic
    @Column(name = "Session_Code", nullable = false)
    public Integer getSessionCode() {
        return sessionCode;
    }

    public void setSessionCode(Integer sessionCode) {
        this.sessionCode = sessionCode;
    }

    @Basic
    @Column(name = "Session_Code_Number", nullable = false)
    public Integer getSessionCodeNumber() {
        return sessionCodeNumber;
    }

    public void setSessionCodeNumber(Integer sessionCodeNumber) {
        this.sessionCodeNumber = sessionCodeNumber;
    }

    @Basic
    @Column(name = "User_Id", nullable = false)
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

        SessionCodeEntity that = (SessionCodeEntity) o;

        if (idSessionCode != null ? !idSessionCode.equals(that.idSessionCode) : that.idSessionCode != null)
            return false;
        if (sessionCode != null ? !sessionCode.equals(that.sessionCode) : that.sessionCode != null) return false;
        if (sessionCodeNumber != null ? !sessionCodeNumber.equals(that.sessionCodeNumber) : that.sessionCodeNumber != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSessionCode != null ? idSessionCode.hashCode() : 0;
        result = 31 * result + (sessionCode != null ? sessionCode.hashCode() : 0);
        result = 31 * result + (sessionCodeNumber != null ? sessionCodeNumber.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "User_Id", referencedColumnName = "Id", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
}
