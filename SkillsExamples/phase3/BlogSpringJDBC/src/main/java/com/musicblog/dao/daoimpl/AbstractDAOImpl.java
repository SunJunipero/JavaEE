package com.musicblog.dao.daoimpl;

import com.musicblog.dao.AbstractDAO;
import com.musicblog.model.BaseEntity;

import java.util.List;

public class AbstractDAOImpl <T extends BaseEntity> implements AbstractDAO<T> {
    @Override
    public T create(T entity) {
        return null;
    }

    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public T getById(Integer id) {
        return null;
    }

    @Override
    public List<T> getAll() {
        return null;
    }
}
