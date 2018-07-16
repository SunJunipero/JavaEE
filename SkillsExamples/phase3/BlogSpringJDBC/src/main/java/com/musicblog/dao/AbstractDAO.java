package com.musicblog.dao;

import java.util.List;

public interface AbstractDAO<T> {
    T create(T entity);
    T update(T entity);
    void delete (T entity);
    T getById(Integer id);
    List<T> getAll();
}
