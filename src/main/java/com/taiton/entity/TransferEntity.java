package com.taiton.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Taiton on 10/27/2016.
 */
@Entity
@Table(name = "transfer", schema = "taitonbankdb", catalog = "")
public class TransferEntity {
    private Integer id;
    private Integer cardFrom;
    private Integer cardTo;
    private Timestamp date;
    private Double amount;
    private CardEntity cardByCardFrom;
    private CardEntity cardByCardTo;

    @Id
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransferEntity that = (TransferEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cardFrom != null ? !cardFrom.equals(that.cardFrom) : that.cardFrom != null) return false;
        if (cardTo != null ? !cardTo.equals(that.cardTo) : that.cardTo != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cardFrom != null ? cardFrom.hashCode() : 0);
        result = 31 * result + (cardTo != null ? cardTo.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
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
