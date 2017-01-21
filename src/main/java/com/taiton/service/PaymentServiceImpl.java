package com.taiton.service;

import com.taiton.dao.AccountDao;
import com.taiton.dao.PaymentDao;
import com.taiton.entity.AccountEntity;
import com.taiton.entity.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taiton on 1/2/2017.
 */
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public List<PaymentEntity> findAll() {
        return paymentDao.findAll();
    }

    @Override
    public PaymentEntity find(int id) {
        return paymentDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        paymentDao.delete(id);
    }

    @Override
    public void save(PaymentEntity paymentEntity) {
        paymentDao.save(paymentEntity);
    }

    @Override
    public List<PaymentEntity> findByCard(int cardNumber) {
        return paymentDao.findByCard(cardNumber);
    }
}
