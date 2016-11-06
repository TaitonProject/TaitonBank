package com.taiton.dao;

import com.taiton.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Taiton on 11/5/2016.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(UserEntity userEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(userEntity);
    }

    public List<UserEntity> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserEntity> userEntityList = session.createQuery("from UserEntity").list();
        return userEntityList;
    }

    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity userEntity = session.load(UserEntity.class, new Integer(id));
        if (userEntity != null)
            session.delete(userEntity);
    }

    public UserEntity getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity userEntity = session.load(UserEntity.class, new Integer(id));
        return userEntity;
    }

    public void updateUser(UserEntity userEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(userEntity);
    }

    public UserEntity findByLoginAndPassword(String login, String password) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from UserEntity as u where u.login=:login and u.password=:password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        List<UserEntity> userEntityList = query.list();
        return userEntityList.isEmpty() ? null : userEntityList.iterator().next();
    }
}
