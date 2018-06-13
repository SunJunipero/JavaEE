package com.example.mvc.dao;

import com.example.mvc.entity.User;

import java.util.List;


public interface UserDao {

    void create(User user);
    void update(User user);
    User getById(Long userId);
    List<User> getAll();
    User getByLogin(String login);
    void delete(User user);

}