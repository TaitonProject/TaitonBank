package com.taiton.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by VitalitY on 14.12.2016.
 */
@Entity
@Table(name = "transfer", schema = "heroku_379802575654769", catalog = "")
public class TransferEntity {
    private int id;
    private Timestamp date;
    private double amount;
    private Integer cardFrom;
    private Integer cardTo;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "Amount", nullable = false, precision = 0)
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransferEntity that = (TransferEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.amount, amount) != 0) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Basic
    @Column(name = "Card_From", nullable = false)
    public Integer getCardFrom() {
        return cardFrom;
    }

    public void setCardFrom(Integer cardFrom) {
        this.cardFrom = cardFrom;
    }

    @Basic
    @Column(name = "Card_To", nullable = false)
    public Integer getCardTo() {
        return cardTo;
    }

    public void setCardTo(Integer cardTo) {
        this.cardTo = cardTo;
    }
}
