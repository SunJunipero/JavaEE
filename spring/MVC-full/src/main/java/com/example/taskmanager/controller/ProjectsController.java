package com.example.taskmanager.controller;

import com.example.taskmanager.dao.AbstractDAO;
import com.example.taskmanager.model.Project;
import com.example.taskmanager.validation.ProjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProjectsController {
    @Autowired
    @Qualifier(value = "projectDAO")
    private AbstractDAO projectDAO;

    @Autowired
    @Qualifier(value = "projectValidator")
    private ProjectValidator projectValidator;

    @RequestMapping("/")
    public String foo(){
        return "redirect:/projects";
    }

    @ModelAttribute("projects")
    public List<Project> getAllproject(){

        return projectDAO.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/projects")
    public String get(Model model){
        model.addAttribute("project", new Project());
        return "projects";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/projects/{action}/{id}")
    public String handleAction(@PathVariable Integer id, @PathVariable String action, Model model){
        Project project = (Project)projectDAO.getById(id);
        if(action.equalsIgnoreCase("edit")){
            model.addAttribute("project", project);
            return "projects";
        }else if(action.equalsIgnoreCase("delete")){
            projectDAO.delete(project);
        }
        return "redirect:/projects";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@ModelAttribute("project") Project project, BindingResult result){
        projectValidator.validate(project, result);
        if(result.hasErrors())
            return "/projects";
        projectDAO.update(project);
        return "redirect:/projects";
    }


}