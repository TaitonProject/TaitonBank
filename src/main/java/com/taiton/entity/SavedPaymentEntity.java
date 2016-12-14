package com.taiton.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by VitalitY on 14.12.2016.
 */
@Entity
@Table(name = "saved_payment", schema = "heroku_379802575654769", catalog = "")
public class SavedPaymentEntity {
    private int id;
    private String name;
    private String info;
    private byte isAuto;
    private Integer period;
    private Timestamp startDate;
    private CardEntity cardByCardId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "isAuto")
    public byte getIsAuto() {
        return isAuto;
    }

    public void setIsAuto(byte isAuto) {
        this.isAuto = isAuto;
    }

    @Basic
    @Column(name = "period")
    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    @Basic
    @Column(name = "startDate")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SavedPaymentEntity that = (SavedPaymentEntity) o;

        if (id != that.id) return false;
        if (isAuto != that.isAuto) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (info != null ? !info.equals(that.info) : that.info != null) return false;
        if (period != null ? !period.equals(that.period) : that.period != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (int) isAuto;
        result = 31 * result + (period != null ? period.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
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
