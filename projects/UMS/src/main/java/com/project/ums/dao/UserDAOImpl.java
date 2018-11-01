package com.project.ums.dao;

import com.project.ums.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements AbstractDAO<User> {

    private User user = new User();

    @Autowired
    protected HibernateTemplate ht;

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
