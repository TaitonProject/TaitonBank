package com.taiton.service;


import com.taiton.dao.TransferDao;
import com.taiton.entity.TransferEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taiton on 1/2/2017.
 */
@Service
@Transactional
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferDao transferDao;

    @Override
    public List<TransferEntity> findAll() {
        return transferDao.findAll();
    }

    @Override
    public TransferEntity find(int id) {
        return transferDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        transferDao.delete(id);
    }

    @Override
    public void save(TransferEntity transferEntity) {
        transferDao.save(transferEntity);
    }

    @Override
    public List<TransferEntity> findByCard(int card) {
        return transferDao.findByCard(card);
    }


}
