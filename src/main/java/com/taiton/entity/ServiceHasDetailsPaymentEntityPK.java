package com.taiton.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.io.Serializable;

/**
 * Created by VitalitY on 14.12.2016.
 */
public class ServiceHasDetailsPaymentEntityPK implements Serializable {
    private int serviceId;
    private int detailsPaymentId;

    @JoinColumn(name = "Service_Id", nullable = false)
    @Id
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @JoinColumn(name = "Details_Payment_Id", nullable = false)
    @Id
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

        ServiceHasDetailsPaymentEntityPK that = (ServiceHasDetailsPaymentEntityPK) o;

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
}
