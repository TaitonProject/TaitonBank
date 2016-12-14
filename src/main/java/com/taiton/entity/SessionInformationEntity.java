package com.taiton.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by VitalitY on 14.12.2016.
 */
@Entity
@Table(name = "session_information", schema = "heroku_379802575654769", catalog = "")
public class SessionInformationEntity {
    private int id;
    private Timestamp sessionStart;
    private Timestamp sessionEnd;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Session_Start")
    public Timestamp getSessionStart() {
        return sessionStart;
    }

    public void setSessionStart(Timestamp sessionStart) {
        this.sessionStart = sessionStart;
    }

    @Basic
    @Column(name = "Session_End")
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

        if (id != that.id) return false;
        if (sessionStart != null ? !sessionStart.equals(that.sessionStart) : that.sessionStart != null) return false;
        if (sessionEnd != null ? !sessionEnd.equals(that.sessionEnd) : that.sessionEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sessionStart != null ? sessionStart.hashCode() : 0);
        result = 31 * result + (sessionEnd != null ? sessionEnd.hashCode() : 0);
        return result;
    }
}
