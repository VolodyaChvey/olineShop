package com.chvei.repository;

import com.chvei.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public class UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Optional<User> findUserByLogin(String login) {
        return sessionFactory.getCurrentSession()
                .createQuery("from User where login=:login")
                .setParameter("login", login)
                .getResultStream()
                .findFirst();
    }

    public int saveUser(User user) {
        return (int) sessionFactory.getCurrentSession()
                .save(user);
    }
}
