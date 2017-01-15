package com.taiton.entity.forJson;

/**
 * Created by Taiton on 1/15/2017.
 */
public class UserAccount {
    private int userId;
    private int number;

    public UserAccount(int userId, int number) {
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
