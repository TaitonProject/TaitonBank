package com.taiton.dao;

import com.taiton.entity.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Taiton on 11/23/2016.
 */
public interface TransferDao extends JpaRepository<TransferEntity, Integer> {

    @Override
    void delete(Integer integer);

    @Query("select a from TransferEntity a where a.cardFrom = ?1 or a.cardTo = ?1 order by a.date")
    List<TransferEntity> findByCard(int card);
}
