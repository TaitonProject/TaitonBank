package com.taiton.service.formatters;

import com.taiton.dao.RoleDao;
import com.taiton.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Taiton on 12/8/2016.
 */
@Service
public class RoleFormatter implements Formatter<RoleEntity> {

    @Autowired
    RoleDao roleDao;

    @Override
    public RoleEntity parse(String s, Locale locale) throws ParseException {
        return roleDao.findByNameRole(s);
    }

    @Override
    public String print(RoleEntity roleEntity, Locale locale) {
        return (roleEntity != null ? roleEntity.getNameRole() : "");
    }
}
