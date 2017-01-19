package com.taiton.service;

import com.taiton.dao.CardDao;
import com.taiton.entity.CardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taiton on 1/2/2017.
 */
@Service
@Transactional
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDao cardDao;

    @Override
    public List<CardEntity> findAll() {
        return cardDao.findAll();
    }

    @Override
    public CardEntity find(int id) {
        return cardDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        cardDao.delete(id);
    }

    @Override
    public void save(CardEntity cardEntity) {
        cardDao.save(cardEntity);
    }

    @Override
    public CardEntity findByCardNumber(int cardNumber) {
        return cardDao.findByCardNumber(cardNumber);
    }

    @Override
    public List<CardEntity> findByUser(int idUser) {
        List<CardEntity> gg = cardDao.findByUser(idUser);
        return gg;
    }
}
