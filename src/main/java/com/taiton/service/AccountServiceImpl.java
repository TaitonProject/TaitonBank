package com.taiton.service;

import com.taiton.dao.AccountDao;
import com.taiton.dao.RoleDao;
import com.taiton.entity.AccountEntity;
import com.taiton.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taiton on 1/2/2017.
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<AccountEntity> findAll() {
        return accountDao.findAll();
    }

    @Override
    public AccountEntity find(int id) {
        return accountDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        accountDao.delete(id);
    }

    @Override
    public void save(AccountEntity accountEntity) {
        accountDao.save(accountEntity);
    }
}
