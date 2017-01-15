package com.taiton.service;

import com.taiton.entity.AccountEntity;
import com.taiton.entity.RoleEntity;

import java.util.List;

/**
 * Created by Taiton on 1/2/2017.
 */
public interface AccountService {
    List<AccountEntity> findAll();

    AccountEntity find(int id);

    void delete(int id);

    void save(AccountEntity accountEntity);

    AccountEntity findByAccountNumber(int accountNumber);
}
