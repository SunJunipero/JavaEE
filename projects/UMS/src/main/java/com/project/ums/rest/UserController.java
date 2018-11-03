package com.project.ums.rest;

import com.project.ums.model.User;
import com.project.ums.service.UserService;
import com.project.ums.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserValidator userValidator;

//    @RequestMapping(value = "users.html", method = RequestMethod.GET)
//    public String getUsers(ModelMap model){
//        List<User> users = userService.getAll();
//        model.put("users", users);
//        return "users";
//    }

    @RequestMapping(value = "users/{id}.html", method = RequestMethod.GET)
    public ModelAndView getUser(@PathVariable String id, ModelMap model){
        model.put("user", userService.getById(Integer.parseInt(id)));
        return new ModelAndView("user",model);
    }

    @RequestMapping(value = "users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable String id, ModelMap model){
        userService.delete(userService.getById(Integer.parseInt(id)));
        model.put("users", userService.getAll());
        return "redirect:/admin";
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/users/edit/{id}")
//    public String edit(@PathVariable String id, @PathVariable String action, Model model) {
//        User user = userService.getById(Integer.parseInt(id));
//        System.out.println("user = " + user);
//        if (user == null)
//            return "redirect:/admin";
//         model.addAttribute("user", user);
//         return "admin";
//    }

    /**
     * add validation binding result
     * @param user
     * @return
     */
    @RequestMapping(value = "adduser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user, BindingResult result){
//        userValidator.validate(user, result);
        System.out.println(user);
        userService.create(user);
//        if (result.hasErrors())
//            return "/admin";
//        userService.create(user);
        return "redirect:/admin";
    }

}
