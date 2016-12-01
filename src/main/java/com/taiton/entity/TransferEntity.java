package com.taiton.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by VitalitY on 02.12.2016.
 */
@Entity
@Table(name = "transfer", schema = "heroku_893975b12603774", catalog = "")
public class TransferEntity {
    private int id;
    private Timestamp date;
    private double amount;
    private CardEntity cardByCardFrom;
    private CardEntity cardByCardTo;

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

    @ManyToOne
    @JoinColumn(name = "Card_From", referencedColumnName = "Id", nullable = false)
    public CardEntity getCardByCardFrom() {
        return cardByCardFrom;
    }

    public void setCardByCardFrom(CardEntity cardByCardFrom) {
        this.cardByCardFrom = cardByCardFrom;
    }

    @ManyToOne
    @JoinColumn(name = "Card_To", referencedColumnName = "Id", nullable = false)
    public CardEntity getCardByCardTo() {
        return cardByCardTo;
    }

    public void setCardByCardTo(CardEntity cardByCardTo) {
        this.cardByCardTo = cardByCardTo;
    }
}
