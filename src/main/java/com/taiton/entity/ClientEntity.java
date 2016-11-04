package com.taiton.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Taiton on 11/4/2016.
 */
@Entity
@Table(name = "client", schema = "taitonbankdb", catalog = "")
public class ClientEntity {
    private Integer id;
    private String firstName;
    private String secondName;
    private String surName;
    private Collection<AccountEntity> accountsById;
    private Collection<ClientInfoEntity> clientInfosById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "First_Name", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "Second_Name", nullable = false, length = 45)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "Sur_Name", nullable = false, length = 45)
    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (secondName != null ? !secondName.equals(that.secondName) : that.secondName != null) return false;
        if (surName != null ? !surName.equals(that.surName) : that.surName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (surName != null ? surName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "clientByClientId")
    public Collection<AccountEntity> getAccountsById() {
        return accountsById;
    }

    public void setAccountsById(Collection<AccountEntity> accountsById) {
        this.accountsById = accountsById;
    }

    @OneToMany(mappedBy = "clientByClientId")
    public Collection<ClientInfoEntity> getClientInfosById() {
        return clientInfosById;
    }

    public void setClientInfosById(Collection<ClientInfoEntity> clientInfosById) {
        this.clientInfosById = clientInfosById;
    }
}
