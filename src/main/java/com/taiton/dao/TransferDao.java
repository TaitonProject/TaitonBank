package com.taiton.dao;

import com.taiton.entity.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Taiton on 11/23/2016.
 */
public interface TransferDao extends JpaRepository<TransferEntity, Integer> {

    @Override
    void delete(Integer integer);

}
