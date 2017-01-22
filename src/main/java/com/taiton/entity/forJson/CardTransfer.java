package com.taiton.entity.forJson;

import com.taiton.entity.CardEntity;
import com.taiton.entity.TransferEntity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Taiton on 1/21/2017.
 */
public class CardTransfer {

    private double amount;
    private String cardTo;
    private String cardFrom;
    private Timestamp date;


    public CardTransfer(double amount, String cardTo, String cardFrom, Timestamp date) {
        this.amount = amount;
        this.cardTo = cardTo;
        this.cardFrom = cardFrom;
        this.date = date;
    }

    public CardTransfer() {
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCardTo() {
        return cardTo;
    }

    public void setCardTo(String cardTo) {
        this.cardTo = cardTo;
    }

    public String getCardFrom() {
        return cardFrom;
    }

    public void setCardFrom(String cardFrom) {
        this.cardFrom = cardFrom;
    }
}
