package com.taiton.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by VitalitY on 14.12.2016.
 */
@Entity
@Table(name = "payment", schema = "heroku_379802575654769", catalog = "")
public class PaymentEntity {
    private int id;
    private Timestamp date;
    private String info;
    private double amount;
    private CardEntity cardByCardId;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "Info")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Basic
    @Column(name = "Amount")
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

        PaymentEntity that = (PaymentEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.amount, amount) != 0) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (info != null ? !info.equals(that.info) : that.info != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "card_Id", referencedColumnName = "Id", nullable = false)
    public CardEntity getCardByCardId() {
        return cardByCardId;
    }

    public void setCardByCardId(CardEntity cardByCardId) {
        this.cardByCardId = cardByCardId;
    }
}
