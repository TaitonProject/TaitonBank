package com.taiton.entity.forJson;

/**
 * Created by Taiton on 1/16/2017.
 */
public class Service {
    private String name;
    private int account;
    private int organizationId;

    public Service(String name, int account, int organizationId) {
        this.name = name;
        this.account = account;
        this.organizationId = organizationId;
    }

    public Service() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }
}
