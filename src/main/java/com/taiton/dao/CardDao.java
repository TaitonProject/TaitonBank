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
    CardEntity findByCardNumber(int cardNumber);

    @Override
    void delete(Integer integer);

}
