package com.project.ums.rest;

import com.project.ums.dao.AbstractDAO;
import com.project.ums.model.User;
import com.project.ums.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserRestController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, headers = {"accept=application/json"})
    public User getUser(@PathVariable String id){
        return ((User) userService.getById(Integer.parseInt(id)));
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, headers = {"accept=application/json"})
    public List<User> getAll(){
        return userService.getAll();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String id){
        User user = (User) userService.getById(Integer.parseInt(id));
        userService.delete(user);
    }

    @RequestMapping(value = "/users/create", method = RequestMethod.POST, headers = {"accept=application/json"})
    public String add (@RequestBody User user){
        userService.create(user);
        return "OK";
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody User user, @PathVariable String id){
        user.setUser_id(Integer.parseInt(id));
        userService.update(user);
        return "OK";
    }

}
