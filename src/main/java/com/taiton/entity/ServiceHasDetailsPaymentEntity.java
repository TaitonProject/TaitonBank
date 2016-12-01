package com.taiton.entity;

import javax.persistence.*;

/**
 * Created by VitalitY on 02.12.2016.
 */
@Entity
@Table(name = "service_has_details_payment", schema = "heroku_893975b12603774", catalog = "")
@IdClass(ServiceHasDetailsPaymentEntityPK.class)
public class ServiceHasDetailsPaymentEntity {
    private int serviceId;
    private int detailsPaymentId;
    private ServiceEntity serviceByServiceId;
    private DetailsPaymentEntity detailsPaymentByDetailsPaymentId;

    @Id
    @Column(name = "Service_Id")
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Id
    @Column(name = "Details_Payment_Id")
    public int getDetailsPaymentId() {
        return detailsPaymentId;
    }

    public void setDetailsPaymentId(int detailsPaymentId) {
        this.detailsPaymentId = detailsPaymentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceHasDetailsPaymentEntity that = (ServiceHasDetailsPaymentEntity) o;

        if (serviceId != that.serviceId) return false;
        if (detailsPaymentId != that.detailsPaymentId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serviceId;
        result = 31 * result + detailsPaymentId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Service_Id", referencedColumnName = "Id", nullable = false)
    public ServiceEntity getServiceByServiceId() {
        return serviceByServiceId;
    }

    public void setServiceByServiceId(ServiceEntity serviceByServiceId) {
        this.serviceByServiceId = serviceByServiceId;
    }

    @ManyToOne
    @JoinColumn(name = "Details_Payment_Id", referencedColumnName = "Id", nullable = false)
    public DetailsPaymentEntity getDetailsPaymentByDetailsPaymentId() {
        return detailsPaymentByDetailsPaymentId;
    }

    public void setDetailsPaymentByDetailsPaymentId(DetailsPaymentEntity detailsPaymentByDetailsPaymentId) {
        this.detailsPaymentByDetailsPaymentId = detailsPaymentByDetailsPaymentId;
    }
}
