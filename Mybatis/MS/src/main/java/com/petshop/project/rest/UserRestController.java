package com.petshop.project.rest;

import com.petshop.project.util.JsonLoad;
import com.petshop.project.mapper.UserMapper;
import com.petshop.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserRestController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/")
    public String mainPage(){
        return "grid";
    }

    @RequestMapping(value = "/users/view", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    JsonLoad getUsers() {
        System.out.println("get user !!!");
        JsonLoad jsonLoad = new JsonLoad();
        List<User> allUsers = userMapper.getAllUsers();
        jsonLoad.add(allUsers);
        jsonLoad.setSuccess(true);
        return jsonLoad;
    }

    @RequestMapping(value = "/users/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    JsonLoad create(@RequestBody User[] users) {
        JsonLoad jsonLoad = new JsonLoad();
        userMapper.addUsers(users);
        jsonLoad.add(users.length);
        jsonLoad.setSuccess(true);
        return jsonLoad;
}

    @RequestMapping(value = "/users/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    JsonLoad update(@RequestBody User[] users) {
        JsonLoad jsonLoad = new JsonLoad();
        userMapper.updateUsers(users);
        jsonLoad.add(users.length);
        jsonLoad.setSuccess(true);
        return jsonLoad;
    }

    @RequestMapping(value = "/users/destroy", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    JsonLoad delete(@RequestBody int[] id) {
        System.out.println("delete user !!!");
        userMapper.deleteUsers(id);
        JsonLoad jsonLoad = new JsonLoad();
        jsonLoad.add(id.length);
        jsonLoad.setSuccess(true);
        return jsonLoad;
    }

}
