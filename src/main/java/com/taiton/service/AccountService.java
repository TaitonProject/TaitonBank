package com.taiton.service;

import com.taiton.entity.AccountEntity;

import java.util.List;

/**
 * Created by Taiton on 1/2/2017.
 */
public interface AccountService {
    List<AccountEntity> findAll();

    AccountEntity find(int id);

    void delete(int id);

    void save(AccountEntity accountEntity);

    AccountEntity findByAccountNumber(String accountNumber);

    List<AccountEntity> findAllUser();

    List<AccountEntity> findAllOrganization();

    List<AccountEntity> findByUserId(int idUser);
}
