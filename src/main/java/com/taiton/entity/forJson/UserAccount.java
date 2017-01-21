package com.taiton.entity.forJson;

/**
 * Created by Taiton on 1/15/2017.
 */
public class UserAccount {
    private int userId;
    private String number;

    public UserAccount(int userId, String number) {
        this.userId = userId;
        this.number = number;
    }

    public UserAccount() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
