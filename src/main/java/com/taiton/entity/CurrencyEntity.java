package com.taiton.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Taiton on 12/1/2016.
 */
@Entity
@Table(name = "currency", schema = "heroku_303647c7ded8d0f", catalog = "")
public class CurrencyEntity {
    private Integer id;
    private String name;
    private Integer code;
    private Double priceBuy;
    private Double priceSell;
    private Collection<AccountEntity> accountsById;

    @Id
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 3)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Code", nullable = false)
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Basic
    @Column(name = "Price_Buy", nullable = false, precision = 0)
    public Double getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(Double priceBuy) {
        this.priceBuy = priceBuy;
    }

    @Basic
    @Column(name = "Price_Sell", nullable = false, precision = 0)
    public Double getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(Double priceSell) {
        this.priceSell = priceSell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrencyEntity that = (CurrencyEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (priceBuy != null ? !priceBuy.equals(that.priceBuy) : that.priceBuy != null) return false;
        if (priceSell != null ? !priceSell.equals(that.priceSell) : that.priceSell != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (priceBuy != null ? priceBuy.hashCode() : 0);
        result = 31 * result + (priceSell != null ? priceSell.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "currencyByCurrencyId")
    public Collection<AccountEntity> getAccountsById() {
        return accountsById;
    }

    public void setAccountsById(Collection<AccountEntity> accountsById) {
        this.accountsById = accountsById;
    }
}
