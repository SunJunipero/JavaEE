package com.project.ums.controller;

import com.project.ums.dao.AbstractDAO;
import com.project.ums.model.User;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private AbstractDAO userDAO;

    public void setUserDAO(AbstractDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User getUser(int id){
        return ((User) userDAO.getById(id));
    }

    public List<User> getAll(){
        return userDAO.getAll();
    }

    public void delete(User user){
        userDAO.delete(user);
    }

    public User add (User user){
        return ((User) userDAO.create(user));
    }

    public User update(User user){
        userDAO.update(user);
        return user;
    }

}
