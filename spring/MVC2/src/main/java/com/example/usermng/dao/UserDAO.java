package com.example.usermng.dao;

import com.example.usermng.model.User;

import java.util.List;

public interface UserDAO {
    void create(User user);
    void update(User user);
    List<User> getAll();
    User getById(Long userId);
    User getByLogin(String login);
    void delete(User user);

}
