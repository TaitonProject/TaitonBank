package com.taiton.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Taiton on 10/27/2016.
 */
public class ServiceHasDetailsPaymentEntityPK implements Serializable {
    private Integer serviceId;
    private Integer detailsPaymentId;

    @Column(name = "Service_Id", nullable = false)
    @Id
    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    @Column(name = "Details_Payment_Id", nullable = false)
    @Id
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

        ServiceHasDetailsPaymentEntityPK that = (ServiceHasDetailsPaymentEntityPK) o;

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
}
