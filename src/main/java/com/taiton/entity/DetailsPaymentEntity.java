package com.taiton.entity;

import javax.persistence.*;

/**
 * Created by VitalitY on 14.12.2016.
 */
@Entity
@Table(name = "details_payment", schema = "heroku_379802575654769", catalog = "")
public class DetailsPaymentEntity {
    private int id;
    private String info;
    private Integer serviceId;

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Info", nullable = false, length = 45)
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetailsPaymentEntity that = (DetailsPaymentEntity) o;

        if (id != that.id) return false;
        if (info != null ? !info.equals(that.info) : that.info != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (info != null ? info.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "service_Id", nullable = false)
    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
}
