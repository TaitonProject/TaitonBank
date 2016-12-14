package com.taiton.entity;

import javax.persistence.*;

/**
 * Created by VitalitY on 14.12.2016.
 */
@Entity
@Table(name = "account", schema = "heroku_379802575654769", catalog = "")
public class AccountEntity {
    private int id;
    private String accountNumber;
    private double accountBalance;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Account_Number")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Basic
    @Column(name = "Account_Balance")
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
        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        temp = Double.doubleToLongBits(accountBalance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
