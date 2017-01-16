package com.taiton.entity;

import javax.persistence.*;

/**
 * Created by VitalitY on 14.12.2016.
 */
@Entity
@Table(name = "account", schema = "heroku_379802575654769", catalog = "")
public class AccountEntity {
    private int id;
    private int accountNumber;
    private double accountBalance;
    private Integer userId;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Account_Number", nullable = false, length = 45)
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Basic
    @Column(name = "Account_Balance", nullable = false, precision = 0)
    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountEntity that = (AccountEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.accountBalance, accountBalance) != 0) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(accountBalance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Basic
    @Column(name = "user_Id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
