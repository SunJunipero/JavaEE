package com.example.mvc.rest;

import com.example.mvc.entity.User;
import com.example.mvc.entity.Users;
import com.example.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserRestController {

    // private static final String VIEW_NAME = "users" ;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/users", headers = {"accept=application/json", "accept=application/xml"})
    public Users getAllUsers(ModelMap model) {
        List<User> users = userService.getAll();
        return  new Users(users);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}", headers = {"accept=application/json", "accept=application/xml"})
    public User getUser(@PathVariable("id") String userId){
        User user = userService.getById(Long.parseLong(userId));
        return user;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/users/create", headers = {"accept=application/json", "accept=application/xml"})
    public String createUser(@RequestBody User user){
        userService.create(user);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") String userId){
        User user = userService.getById(Long.parseLong(userId));
        userService.delete(user);
        return "ok";
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    @ResponseBody
    public String updateUser(@PathVariable("id") String userId, @RequestBody User user){
        user.setUserId(Long.parseLong(userId));
        userService.update(user);
        return "ok";
    }


}