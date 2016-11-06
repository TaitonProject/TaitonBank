package com.taiton.service;

import com.taiton.dao.UserDao;
import com.taiton.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taiton on 11/5/2016.
 */
@Service("provider")
public class CustomAuthenticationProvaider implements AuthenticationProvider {
    @Autowired
    private UserDao userDao;

    @Transactional
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        final UserEntity userEntity = userDao.findByLoginAndPassword(login, password);
        if (userEntity != null){
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            grantedAuthorities.add(new SimpleGrantedAuthority(userEntity.getRole().toString()));
            return new UsernamePasswordAuthenticationToken(login, password, grantedAuthorities);
        }
        return null;
    }

    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
