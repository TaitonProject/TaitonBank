package com.taiton.service;

import com.taiton.entity.CardEntity;

import java.util.List;

/**
 * Created by Taiton on 1/2/2017.
 */
public interface CardService {
    List<CardEntity> findAll();

    CardEntity find(int id);

    void delete(int id);

    void save(CardEntity cardEntity);

    CardEntity findByCardNumber(int cardNumber);

    List<CardEntity> findByUser(int idUser);

}
