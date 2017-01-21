package com.taiton.entity.forJson;

/**
 * Created by Taiton on 1/21/2017.
 */
public class CardBalance {
    private int cardNumber;
    private double balance;

    public CardBalance(int cardNumber, double balance) {
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public CardBalance() {
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
