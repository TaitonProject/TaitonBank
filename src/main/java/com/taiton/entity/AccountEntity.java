package com.taiton.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Taiton on 10/27/2016.
 */
@Entity
@Table(name = "account", schema = "taitonbankdb", catalog = "")
public class AccountEntity {
    private Integer id;
    private String accountNumber;
    private Double accountBalance;
    private Integer userId;
    private Integer currencyId;
    private Integer organiztaionId;
    private UserEntity userByUserId;
    private CurrencyEntity currencyByCurrencyId;
    private ServiceEntity serviceByOrganiztaionId;
    private Collection<CardEntity> cardsById;
    private Collection<PaymentEntity> paymentsById;

    @Id
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Account_Number", nullable = false, length = 45)
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Basic
    @Column(name = "Account_Balance", nullable = false, precision = 0)
    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Basic
    @Column(name = "User_Id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Currency_Id", nullable = false)
    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    @Basic
    @Column(name = "Organiztaion_Id", nullable = true)
    public Integer getOrganiztaionId() {
        return organiztaionId;
    }

    public void setOrganiztaionId(Integer organiztaionId) {
        this.organiztaionId = organiztaionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountEntity that = (AccountEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
            return false;
        if (accountBalance != null ? !accountBalance.equals(that.accountBalance) : that.accountBalance != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (currencyId != null ? !currencyId.equals(that.currencyId) : that.currencyId != null) return false;
        if (organiztaionId != null ? !organiztaionId.equals(that.organiztaionId) : that.organiztaionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + (accountBalance != null ? accountBalance.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (currencyId != null ? currencyId.hashCode() : 0);
        result = 31 * result + (organiztaionId != null ? organiztaionId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "User_Id", referencedColumnName = "Id")
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "Currency_Id", referencedColumnName = "Id", nullable = false)
    public CurrencyEntity getCurrencyByCurrencyId() {
        return currencyByCurrencyId;
    }

    public void setCurrencyByCurrencyId(CurrencyEntity currencyByCurrencyId) {
        this.currencyByCurrencyId = currencyByCurrencyId;
    }

    @ManyToOne
    @JoinColumn(name = "Organiztaion_Id", referencedColumnName = "Id")
    public ServiceEntity getServiceByOrganiztaionId() {
        return serviceByOrganiztaionId;
    }

    public void setServiceByOrganiztaionId(ServiceEntity serviceByOrganiztaionId) {
        this.serviceByOrganiztaionId = serviceByOrganiztaionId;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<CardEntity> getCardsById() {
        return cardsById;
    }

    public void setCardsById(Collection<CardEntity> cardsById) {
        this.cardsById = cardsById;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<PaymentEntity> getPaymentsById() {
        return paymentsById;
    }

    public void setPaymentsById(Collection<PaymentEntity> paymentsById) {
        this.paymentsById = paymentsById;
    }
}
