package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.security.Principal;


@Controller
public class TestController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){
        return "login";
    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginfaild(Model model){
        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model){
        return "login";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String test(Model model, Principal principal){
        String name = principal.getName();
        model.addAttribute("username", name);
        model.addAttribute("message", "this is spring-security");
        return "test";
    }


}
