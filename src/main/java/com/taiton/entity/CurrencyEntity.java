package com.taiton.entity;

import javax.persistence.*;

/**
 * Created by VitalitY on 02.12.2016.
 */
@Entity
@Table(name = "currency", schema = "heroku_893975b12603774", catalog = "")
public class CurrencyEntity {
    private int id;
    private String name;
    private int code;
    private double priceBuy;
    private double priceSell;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Code")
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Basic
    @Column(name = "Price_Buy")
    public double getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(double priceBuy) {
        this.priceBuy = priceBuy;
    }

    @Basic
    @Column(name = "Price_Sell")
    public double getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(double priceSell) {
        this.priceSell = priceSell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrencyEntity that = (CurrencyEntity) o;

        if (id != that.id) return false;
        if (code != that.code) return false;
        if (Double.compare(that.priceBuy, priceBuy) != 0) return false;
        if (Double.compare(that.priceSell, priceSell) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + code;
        temp = Double.doubleToLongBits(priceBuy);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(priceSell);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
