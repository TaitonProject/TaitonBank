package com.taiton.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Taiton on 11/4/2016.
 */
@Entity
@Table(name = "details_payment", schema = "taitonbankdb", catalog = "")
public class DetailsPaymentEntity {
    private Integer id;
    private String info;
    private Collection<ServiceHasDetailsPaymentEntity> serviceHasDetailsPaymentsById;

    @Id
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (info != null ? !info.equals(that.info) : that.info != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (info != null ? info.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "detailsPaymentByDetailsPaymentId")
    public Collection<ServiceHasDetailsPaymentEntity> getServiceHasDetailsPaymentsById() {
        return serviceHasDetailsPaymentsById;
    }

    public void setServiceHasDetailsPaymentsById(Collection<ServiceHasDetailsPaymentEntity> serviceHasDetailsPaymentsById) {
        this.serviceHasDetailsPaymentsById = serviceHasDetailsPaymentsById;
    }
}
