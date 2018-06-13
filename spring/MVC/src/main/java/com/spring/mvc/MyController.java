package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/hello")
public class MyController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC Hello World");
        return "hello";
    }

    @RequestMapping(value = "/bye" ,method = RequestMethod.GET)
    public String sayBye(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC bye-bye!");
        return "bye";
    }

}