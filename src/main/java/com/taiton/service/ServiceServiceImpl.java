package com.taiton.service;

import com.taiton.dao.AccountDao;
import com.taiton.dao.ServiceDao;
import com.taiton.entity.AccountEntity;
import com.taiton.entity.ServiceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taiton on 1/2/2017.
 */
@Service
@Transactional
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceDao serviceDao;

    @Override
    public List<ServiceEntity> findAll() {
        return serviceDao.findAll();
    }

    @Override
    public ServiceEntity find(int id) {
        return serviceDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        serviceDao.delete(id);
    }

    @Override
    public void save(ServiceEntity serviceEntity) {
        serviceDao.save(serviceEntity);
    }

    @Override
    public ServiceEntity findByName(String name) {
        return serviceDao.findByName(name);
    }
}
