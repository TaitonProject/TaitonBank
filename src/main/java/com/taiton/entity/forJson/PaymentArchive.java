package com.taiton.entity.forJson;

import com.taiton.entity.OrganizationEntity;
import com.taiton.entity.PaymentEntity;
import com.taiton.entity.ServiceEntity;

/**
 * Created by Taiton on 1/21/2017.
 */
public class PaymentArchive {
    private PaymentEntity paymentEntity;
    private String serviceName;
    private String organizationName;

    public PaymentArchive(PaymentEntity paymentEntity, String serviceName, String organizationName) {
        this.paymentEntity = paymentEntity;
        this.serviceName = serviceName;
        this.organizationName = organizationName;
    }

    public PaymentArchive() {
    }

    public PaymentEntity getPaymentEntity() {
        return paymentEntity;
    }

    public void setPaymentEntity(PaymentEntity paymentEntity) {
        this.paymentEntity = paymentEntity;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}
