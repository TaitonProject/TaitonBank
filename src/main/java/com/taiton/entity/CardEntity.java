package com.taiton.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.taiton.jsonConverter.CardDeserializer;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by VitalitY on 14.12.2016.
 */
@JsonDeserialize(using = CardDeserializer.class)
@Entity
@Table(name = "card", schema = "heroku_379802575654769", catalog = "")
public class CardEntity {
    private int id;
    private int cardNumber;
    private Date dateOfExpiry;
    private AccountEntity accountByAccountId;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Card_Number")
    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Basic
    @Column(name = "Date_Of_Expiry")
    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardEntity that = (CardEntity) o;

        if (id != that.id) return false;
        if (cardNumber != that.cardNumber) return false;
        if (dateOfExpiry != null ? !dateOfExpiry.equals(that.dateOfExpiry) : that.dateOfExpiry != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + cardNumber;
        result = 31 * result + (dateOfExpiry != null ? dateOfExpiry.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Account_Id", referencedColumnName = "Id", nullable = false)
    public AccountEntity getAccountByAccountId() {
        return accountByAccountId;
    }

    public void setAccountByAccountId(AccountEntity accountByAccountId) {
        this.accountByAccountId = accountByAccountId;
    }
}
