package com.project.ums.service;

import com.project.ums.dao.AbstractDAO;
import com.project.ums.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public AbstractDAO userDAO;

    @Transactional
    public void create(User user) {
        userDAO.create(user);
    }

    @Transactional
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }

    @Transactional
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Transactional
    public User getById(int userId) {
        return ((User) userDAO.getById(userId));
    }
}
