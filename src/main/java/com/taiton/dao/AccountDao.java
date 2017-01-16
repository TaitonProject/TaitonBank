package com.taiton.dao;

import com.taiton.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Taiton on 11/23/2016.
 */
public interface AccountDao extends JpaRepository<AccountEntity, Integer> {

    //@Query("select a from AccountEntity a where a.accountNumber = ?1")
    AccountEntity findByAccountNumber(int accountNumber);

    @Override
    void delete(Integer integer);

    @Query("select a from AccountEntity a where a.userId is null")
    List<AccountEntity> findAllOrganization();

    @Query("select a from AccountEntity a where a.organizationId is null")
    List<AccountEntity> findAllUser();

}
