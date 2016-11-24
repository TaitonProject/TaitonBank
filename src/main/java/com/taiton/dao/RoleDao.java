package com.taiton.dao;

import com.taiton.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Taiton on 11/23/2016.
 */
public interface RoleDao extends JpaRepository<RolesEntity, Long> {
}
