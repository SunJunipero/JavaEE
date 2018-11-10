package com.petshop.project.controllers;

import com.petshop.project.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String getUsers(Model model){
        model.addAttribute("users", userMapper.getAllUsers());
        return "users";
    }
}
