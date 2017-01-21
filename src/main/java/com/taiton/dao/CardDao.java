package com.taiton.dao;

import com.taiton.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Taiton on 11/23/2016.
 */
public interface CardDao extends JpaRepository<CardEntity, Integer> {

    //@Query("select a from AccountEntity a where a.accountNumber = ?1")
    CardEntity findByCardNumber(String cardNumber);

    @Override
    void delete(Integer integer);

    @Query("select a from CardEntity a, AccountEntity b where a.accountId = b.id and b.userId = ?1")
    List<CardEntity> findByUser(int idUser);

}
