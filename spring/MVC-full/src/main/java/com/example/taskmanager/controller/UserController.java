package com.example.taskmanager.controller;

import com.example.taskmanager.dao.AbstractDAO;
import com.example.taskmanager.model.User;
import com.example.taskmanager.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class UserController {
    @Autowired
    @Qualifier(value = "userDao")
    private AbstractDAO userDao;

    @Autowired
    @Qualifier(value = "userValidator")
    private UserValidator userValidator;


    @ModelAttribute("users")
    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public String get(Model model) {
        model.addAttribute("user", new User());
        return "users";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{action}/{id}")
    public String handleAction(@PathVariable String id, @PathVariable String action, Model model) {
        User user = (User) userDao.getById(Integer.valueOf(id));
        System.out.println("user = " + user);
        if (user == null)
            return "redirect:/users";
        if (action.equalsIgnoreCase("edit")) {
            model.addAttribute("user", user);
            return "users";
        } else if (action.equalsIgnoreCase("delete")) {
            userDao.delete(user);
        }
        return "redirect:/users";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/adduser")
    public String add(@ModelAttribute("user") User user, BindingResult result) {
        userValidator.validate(user, result);
        if (result.hasErrors())
            return "/users";

        userDao.update(user);
        return "redirect:/users";

    }
}
