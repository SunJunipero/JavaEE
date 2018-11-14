package com.petshop.project.controllers;

import com.petshop.project.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class SecurityController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model, Principal principal){
        String name = principal.getName();
        model.addAttribute("username", name);
        model.addAttribute("users", userMapper.getAllUsers());
        model.addAttribute("roles", SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return "welcome";
    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String test(Model model){
        model.addAttribute("error", "true");
        System.out.println(userMapper.getAllUsers());
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout() {
        return "login";

    }
}
