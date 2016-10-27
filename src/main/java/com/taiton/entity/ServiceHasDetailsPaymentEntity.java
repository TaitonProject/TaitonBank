package com.taiton.entity;

import javax.persistence.*;

/**
 * Created by Taiton on 10/27/2016.
 */
@Entity
@Table(name = "service_has_details_payment", schema = "taitonbankdb", catalog = "")
@IdClass(ServiceHasDetailsPaymentEntityPK.class)
public class ServiceHasDetailsPaymentEntity {
    private Integer serviceId;
    private Integer detailsPaymentId;
    private ServiceEntity serviceByServiceId;
    private DetailsPaymentEntity detailsPaymentByDetailsPaymentId;

    @Id
    @Column(name = "Service_Id", nullable = false)
    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    @Id
    @Column(name = "Details_Payment_Id", nullable = false)
    public Integer getDetailsPaymentId() {
        return detailsPaymentId;
    }

    public void setDetailsPaymentId(Integer detailsPaymentId) {
        this.detailsPaymentId = detailsPaymentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceHasDetailsPaymentEntity that = (ServiceHasDetailsPaymentEntity) o;

        if (serviceId != null ? !serviceId.equals(that.serviceId) : that.serviceId != null) return false;
        if (detailsPaymentId != null ? !detailsPaymentId.equals(that.detailsPaymentId) : that.detailsPaymentId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serviceId != null ? serviceId.hashCode() : 0;
        result = 31 * result + (detailsPaymentId != null ? detailsPaymentId.hashCode() : 0);
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
