package com.taiton.service;

import com.taiton.entity.AccountEntity;
import com.taiton.entity.TransferEntity;

import java.util.List;

/**
 * Created by Taiton on 1/2/2017.
 */
public interface TransferService {
    List<TransferEntity> findAll();

    TransferEntity find(int id);

    void delete(int id);

    void save(TransferEntity transferEntity);

}
