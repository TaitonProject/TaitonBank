package com.taiton.service;

import com.taiton.entity.AccountEntity;
import com.taiton.entity.PaymentEntity;

import java.util.List;

/**
 * Created by Taiton on 1/2/2017.
 */
public interface PaymentService {
    List<PaymentEntity> findAll();

    PaymentEntity find(int id);

    void delete(int id);

    void save(PaymentEntity paymentEntity);
}
