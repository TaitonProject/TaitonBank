package com.taiton.entity;

import javax.persistence.*;

/**
 * Created by Taiton on 10/27/2016.
 */
@Entity
@Table(name = "exchange", schema = "taitonbankdb", catalog = "")
public class ExchangeEntity {
    private Integer id;
    private Integer currencyOriginal;
    private Integer currencyUltimate;
    private Double ratio;
    private CurrencyEntity currencyByCurrencyOriginal;
    private CurrencyEntity currencyByCurrencyUltimate;

    @Id
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Currency_Original", nullable = false)
    public Integer getCurrencyOriginal() {
        return currencyOriginal;
    }

    public void setCurrencyOriginal(Integer currencyOriginal) {
        this.currencyOriginal = currencyOriginal;
    }

    @Basic
    @Column(name = "Currency_Ultimate", nullable = false)
    public Integer getCurrencyUltimate() {
        return currencyUltimate;
    }

    public void setCurrencyUltimate(Integer currencyUltimate) {
        this.currencyUltimate = currencyUltimate;
    }

    @Basic
    @Column(name = "Ratio", nullable = false, precision = 0)
    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExchangeEntity that = (ExchangeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (currencyOriginal != null ? !currencyOriginal.equals(that.currencyOriginal) : that.currencyOriginal != null)
            return false;
        if (currencyUltimate != null ? !currencyUltimate.equals(that.currencyUltimate) : that.currencyUltimate != null)
            return false;
        if (ratio != null ? !ratio.equals(that.ratio) : that.ratio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (currencyOriginal != null ? currencyOriginal.hashCode() : 0);
        result = 31 * result + (currencyUltimate != null ? currencyUltimate.hashCode() : 0);
        result = 31 * result + (ratio != null ? ratio.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Currency_Original", referencedColumnName = "Id", nullable = false)
    public CurrencyEntity getCurrencyByCurrencyOriginal() {
        return currencyByCurrencyOriginal;
    }

    public void setCurrencyByCurrencyOriginal(CurrencyEntity currencyByCurrencyOriginal) {
        this.currencyByCurrencyOriginal = currencyByCurrencyOriginal;
    }

    @ManyToOne
    @JoinColumn(name = "Currency_Ultimate", referencedColumnName = "Id", nullable = false)
    public CurrencyEntity getCurrencyByCurrencyUltimate() {
        return currencyByCurrencyUltimate;
    }

    public void setCurrencyByCurrencyUltimate(CurrencyEntity currencyByCurrencyUltimate) {
        this.currencyByCurrencyUltimate = currencyByCurrencyUltimate;
    }
}
