package com.example.usermng.dao;

import com.example.usermng.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void create(User user) {
        sessionFactory.getCurrentSession().save(user);

    }

    public void update(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public List<User> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM User order by login").list();
    }

    public User getById(Long userId) {
        return ((User) sessionFactory.getCurrentSession().get(User.class, userId));
    }

    public User getByLogin(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.login = ?");
        query.setString(0, login);
        return (User) query.list().get(0);
    }

    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }
}
