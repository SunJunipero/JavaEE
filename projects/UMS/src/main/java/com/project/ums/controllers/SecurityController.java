package com.project.ums.controllers;

import com.project.ums.service.UserService;
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
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model, Principal principal){
        String name = principal.getName();
        model.addAttribute("username", name);
        model.addAttribute("users", userService.getAll());
        model.addAttribute("roles", SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return "welcome";
    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String test(Model model){
        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model){
        model.addAttribute("users", userService.getAll());
        return "admin";
    }
}
