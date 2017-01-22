package com.taiton.entity.forJson;

import java.sql.Date;

/**
 * Created by Taiton on 1/21/2017.
 */
public class CardBalance {
    private String cardNumber;
    private double balance;
    private String accountNumber;
    private Date date;

    public CardBalance(String cardNumber, double balance, String accountNumber, Date date) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.date = date;
    }

    public CardBalance() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
