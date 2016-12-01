package com.taiton.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Taiton on 12/1/2016.
 */
@Entity
@Table(name = "service", schema = "heroku_303647c7ded8d0f", catalog = "")
public class ServiceEntity {
    private Integer id;
    private Double comission;
    private String name;
    private Collection<AccountEntity> accountsById;
    private Collection<PaymentEntity> paymentsById;
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
    @Column(name = "Comission", nullable = false, precision = 0)
    public Double getComission() {
        return comission;
    }

    public void setComission(Double comission) {
        this.comission = comission;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceEntity that = (ServiceEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (comission != null ? !comission.equals(that.comission) : that.comission != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (comission != null ? comission.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "serviceByOrganiztaionId")
    public Collection<AccountEntity> getAccountsById() {
        return accountsById;
    }

    public void setAccountsById(Collection<AccountEntity> accountsById) {
        this.accountsById = accountsById;
    }

    @OneToMany(mappedBy = "serviceByServiceId")
    public Collection<PaymentEntity> getPaymentsById() {
        return paymentsById;
    }

    public void setPaymentsById(Collection<PaymentEntity> paymentsById) {
        this.paymentsById = paymentsById;
    }

    @OneToMany(mappedBy = "serviceByServiceId")
    public Collection<ServiceHasDetailsPaymentEntity> getServiceHasDetailsPaymentsById() {
        return serviceHasDetailsPaymentsById;
    }

    public void setServiceHasDetailsPaymentsById(Collection<ServiceHasDetailsPaymentEntity> serviceHasDetailsPaymentsById) {
        this.serviceHasDetailsPaymentsById = serviceHasDetailsPaymentsById;
    }
}
