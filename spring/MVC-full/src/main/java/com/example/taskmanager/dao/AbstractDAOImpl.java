package com.example.taskmanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

public class AbstractDAOImpl<T> implements AbstractDAO<T> {

    private Class<T> type;

    @Autowired
    protected HibernateTemplate ht;

    public AbstractDAOImpl(Class<T> type) {
        this.type = type;
    }

    public T getById(Integer id) {
        return ht.get(type, id);
    }

    public List<T> getAll() {
        return ht.loadAll(type);
    }

    public T create(T entity) {
        ht.save(entity);
        return entity;
    }

    public T update(T entity) {
        ht.getSessionFactory().getCurrentSession().clear();
        ht.saveOrUpdate(entity);
        return entity;
    }

    public void delete(T entity) {
        ht.delete(entity);
    }
}
