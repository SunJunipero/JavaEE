package com.project.ums.dao;

import com.project.ums.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class UserDAOImpl implements AbstractDAO<User> {

    private User user;

    @Autowired
    protected HibernateTemplate ht;


    public UserDAOImpl(User user) {
        this.user = user;
    }

    public User getById(int id) {
        return ht.get(user.getClass(), id);
    }

    public List<User> getAll() {
        return (List<User>) ht.loadAll(user.getClass());
    }

    public User create(User entity) {
        ht.save(entity);
        return entity;
    }

    public User update(User entity) {
        ht.getSessionFactory().getCurrentSession().clear();
        ht.saveOrUpdate(entity);
        return entity;
    }

    public void delete(User entity) {
        ht.delete(entity);
    }
}
