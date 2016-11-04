package com.taiton.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Taiton on 11/4/2016.
 */
@Entity
@Table(name = "session_information", schema = "ibankdb", catalog = "")
public class SessionInformationEntity {
    private Integer id;
    private Timestamp sessionStart;
    private Timestamp sessionEnd;
    private UserEntity userByUserId;

    @Id
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Session_Start", nullable = false)
    public Timestamp getSessionStart() {
        return sessionStart;
    }

    public void setSessionStart(Timestamp sessionStart) {
        this.sessionStart = sessionStart;
    }

    @Basic
    @Column(name = "Session_End", nullable = false)
    public Timestamp getSessionEnd() {
        return sessionEnd;
    }

    public void setSessionEnd(Timestamp sessionEnd) {
        this.sessionEnd = sessionEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionInformationEntity that = (SessionInformationEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (sessionStart != null ? !sessionStart.equals(that.sessionStart) : that.sessionStart != null) return false;
        if (sessionEnd != null ? !sessionEnd.equals(that.sessionEnd) : that.sessionEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (sessionStart != null ? sessionStart.hashCode() : 0);
        result = 31 * result + (sessionEnd != null ? sessionEnd.hashCode() : 0);
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
