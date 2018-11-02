package com.project.ums.rest;

import com.project.ums.model.User;
import com.project.ums.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

//    @RequestMapping(value = "users.html", method = RequestMethod.GET)
//    public String getUsers(ModelMap model){
//        List<User> users = userService.getAll();
//        model.put("users", users);
//        return "users";
//    }

//    @RequestMapping(value = "users/{id}.html", method = RequestMethod.GET)
//    public ModelAndView getUser(@PathVariable String id, ModelMap model){
//        model.put("user", userService.getById(Integer.parseInt(id)));
//        return new ModelAndView("user",model);
//    }

}
