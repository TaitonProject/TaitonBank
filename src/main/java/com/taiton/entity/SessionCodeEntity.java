package com.taiton.entity;

import javax.persistence.*;

/**
 * Created by VitalitY on 02.12.2016.
 */
@Entity
@Table(name = "session_code", schema = "heroku_893975b12603774", catalog = "")
public class SessionCodeEntity {
    private int idSessionCode;
    private int sessionCode;
    private int sessionCodeNumber;

    @Id
    @Column(name = "Id_Session_Code")
    public int getIdSessionCode() {
        return idSessionCode;
    }

    public void setIdSessionCode(int idSessionCode) {
        this.idSessionCode = idSessionCode;
    }

    @Basic
    @Column(name = "Session_Code")
    public int getSessionCode() {
        return sessionCode;
    }

    public void setSessionCode(int sessionCode) {
        this.sessionCode = sessionCode;
    }

    @Basic
    @Column(name = "Session_Code_Number")
    public int getSessionCodeNumber() {
        return sessionCodeNumber;
    }

    public void setSessionCodeNumber(int sessionCodeNumber) {
        this.sessionCodeNumber = sessionCodeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionCodeEntity that = (SessionCodeEntity) o;

        if (idSessionCode != that.idSessionCode) return false;
        if (sessionCode != that.sessionCode) return false;
        if (sessionCodeNumber != that.sessionCodeNumber) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSessionCode;
        result = 31 * result + sessionCode;
        result = 31 * result + sessionCodeNumber;
        return result;
    }
}
