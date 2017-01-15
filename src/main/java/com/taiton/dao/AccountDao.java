package com.taiton.dao;

import com.taiton.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Taiton on 11/23/2016.
 */
public interface AccountDao extends JpaRepository<AccountEntity, Integer> {

    @Override
    void delete(Integer integer);
}
