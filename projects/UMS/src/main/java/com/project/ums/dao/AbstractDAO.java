package com.project.ums.dao;

import java.util.List;

public interface AbstractDAO <T> {
    T getById(int id);
    List<T> getAll();
    T create(T entity);
    T update(T entity);
    void delete(T entity);
}
