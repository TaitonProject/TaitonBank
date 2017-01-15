package com.taiton.entity.forJson;

/**
 * Created by Taiton on 1/15/2017.
 */
public class UserBalance {
    private int accountNumber;
    private double accountBalance;

    public UserBalance(int accountNumber, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public UserBalance() {
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
