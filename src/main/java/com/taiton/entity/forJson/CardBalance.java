package com.taiton.entity.forJson;

/**
 * Created by Taiton on 1/21/2017.
 */
public class CardBalance {
    private String cardNumber;
    private double balance;

    public CardBalance(String cardNumber, double balance) {
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public CardBalance() {
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
