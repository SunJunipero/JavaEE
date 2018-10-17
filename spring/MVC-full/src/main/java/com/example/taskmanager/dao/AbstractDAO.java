package com.example.taskmanager.dao;

import java.util.List;

public interface AbstractDAO <T>{
    T getById(Integer id);
    List<T> getAll();
    T create (T entity);
    T update (T entity);
    void delete (T entity);
}
