package com.taiton.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Taiton on 11/4/2016.
 */
@Entity
@Table(name = "currency", schema = "taitonbankdb", catalog = "")
public class CurrencyEntity {
    private Integer id;
    private String name;
    private Integer code;
    private Collection<AccountEntity> accountsById;
    private Collection<ExchangeEntity> exchangesById;
    private Collection<ExchangeEntity> exchangesById_0;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrencyEntity that = (CurrencyEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "currencyByCurrencyId")
    public Collection<AccountEntity> getAccountsById() {
        return accountsById;
    }

    public void setAccountsById(Collection<AccountEntity> accountsById) {
        this.accountsById = accountsById;
    }

    @OneToMany(mappedBy = "currencyByCurrencyOriginal")
    public Collection<ExchangeEntity> getExchangesById() {
        return exchangesById;
    }

    public void setExchangesById(Collection<ExchangeEntity> exchangesById) {
        this.exchangesById = exchangesById;
    }

    @OneToMany(mappedBy = "currencyByCurrencyUltimate")
    public Collection<ExchangeEntity> getExchangesById_0() {
        return exchangesById_0;
    }

    public void setExchangesById_0(Collection<ExchangeEntity> exchangesById_0) {
        this.exchangesById_0 = exchangesById_0;
    }
}
