package com.taiton.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Taiton on 11/4/2016.
 */
@Entity
@Table(name = "card", schema = "taitonbankdb", catalog = "")
public class CardEntity {
    private Integer id;
    private Integer cardNumber;
    private Date dateOfExpiry;
    private Integer accountId;
    private AccountEntity accountByAccountId;
    private Collection<TransferEntity> transfersById;
    private Collection<TransferEntity> transfersById_0;

    @Id
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Card_Number", nullable = false)
    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Basic
    @Column(name = "Date_Of_Expiry", nullable = false)
    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    @Basic
    @Column(name = "Account_Id", nullable = false)
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardEntity that = (CardEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cardNumber != null ? !cardNumber.equals(that.cardNumber) : that.cardNumber != null) return false;
        if (dateOfExpiry != null ? !dateOfExpiry.equals(that.dateOfExpiry) : that.dateOfExpiry != null) return false;
        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cardNumber != null ? cardNumber.hashCode() : 0);
        result = 31 * result + (dateOfExpiry != null ? dateOfExpiry.hashCode() : 0);
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
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

    @OneToMany(mappedBy = "cardByCardFrom")
    public Collection<TransferEntity> getTransfersById() {
        return transfersById;
    }

    public void setTransfersById(Collection<TransferEntity> transfersById) {
        this.transfersById = transfersById;
    }

    @OneToMany(mappedBy = "cardByCardTo")
    public Collection<TransferEntity> getTransfersById_0() {
        return transfersById_0;
    }

    public void setTransfersById_0(Collection<TransferEntity> transfersById_0) {
        this.transfersById_0 = transfersById_0;
    }
}
