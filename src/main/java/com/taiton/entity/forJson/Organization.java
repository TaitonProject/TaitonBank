package com.taiton.entity.forJson;

/**
 * Created by Taiton on 1/16/2017.
 */
public class Organization {
    private String name;

    public Organization(String name) {
        this.name = name;
    }

    public Organization() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
