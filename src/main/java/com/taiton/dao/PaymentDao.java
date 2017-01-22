package com.taiton.dao;

import com.taiton.entity.AccountEntity;
import com.taiton.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Taiton on 11/23/2016.
 */
public interface PaymentDao extends JpaRepository<PaymentEntity, Integer> {

    @Override
    void delete(Integer integer);

    @Query("select a from PaymentEntity a where a.cardId = ?1 order by a.date")
    List<PaymentEntity> findByCard(int cardNumber);
}
