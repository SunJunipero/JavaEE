package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/welcome")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public String test(Model model){
        model.addAttribute("message", "from spring security");
        return "test";

    }

}
