package com.ajax.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class AjaxController {
    @RequestMapping(value = "/helloajax", method = RequestMethod.GET)
    public @ResponseBody String sayHello(){
        return "hello ajax";
    }

    @RequestMapping(value = "/sum", method = RequestMethod.GET)
    public @ResponseBody String sum(@RequestParam String val1, @RequestParam String val2){
        return String.valueOf(Integer.parseInt(val1) + Integer.parseInt(val2));
    }

    @RequestMapping(value = "/oldsum", method = RequestMethod.GET)
    public @ResponseBody void oldsum(@RequestParam String val1, @RequestParam String val2, HttpServletResponse response) throws IOException {
         Integer res = Integer.parseInt(val1) + Integer.parseInt(val2);
         response.setContentType("text/plain");
         PrintWriter writer = response.getWriter();
         writer.write(res + "");
         writer.flush();
         writer.close();
    }
}

