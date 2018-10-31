package com.project.ums.controller;

import com.project.ums.dao.AbstractDAO;
import com.project.ums.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private AbstractDAO userDAO;

    public void setUserDAO(AbstractDAO userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, headers = "accept=application/json")
    public User getUser(@PathVariable String id){
        return ((User) userDAO.getById(Integer.parseInt(id)));
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, headers = "accept=application/json")
    public List<User> getAll(){
        return userDAO.getAll();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String id){
        User user = (User) userDAO.getById(Integer.parseInt(id));
        userDAO.delete(user);
    }

    @RequestMapping(value = "/users/create", method = RequestMethod.POST, headers = "accept=application/json")
    public User add (@RequestBody User user){
        return ((User) userDAO.create(user));
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public User update(@RequestBody User user, @PathVariable String id){
        user.setUser_id(Integer.parseInt(id));
        userDAO.update(user);
        return user;
    }

}
