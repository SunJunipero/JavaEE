package com.example.taskmanager.controller;

import com.example.taskmanager.dao.AbstractDAO;
import com.example.taskmanager.model.Project;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.User;
import com.example.taskmanager.validation.TaskValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.util.List;

public class TaskController {
    @Autowired
    @Qualifier(value = "taskDao")
    private AbstractDAO taskDao;

    @Autowired
    @Qualifier(value = "projectDao")
    private AbstractDAO projectDao;

    @Autowired
    @Qualifier(value = "userDao")
    private AbstractDAO userDao;

    @Autowired
    @Qualifier(value = "taskValidator")
    private TaskValidator taskValidator;

    @ModelAttribute("tasks")
    public List<Task> getAllTasks() {
        return taskDao.getAll();
    }

    @ModelAttribute("projects")
    public List<Project> getAllProjects() {
        return projectDao.getAll();
    }

    @ModelAttribute("users")
    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tasks")
    public String get(Model model){
        model.addAttribute("task", new Task());
        return "tasks";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addtask")
    public String add(@ModelAttribute("task") Task task, BindingResult result){
        taskValidator.validate(task, result);
        if(result.hasErrors())
            return "/tasks";
        projectDao.update(task);
        return "redirect:/tasks";
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Project.class, "project", new PropertyEditorSupport() {

            public void setAsText(String text) {
                if (text instanceof String) {
                    Integer projectId = Integer.parseInt(text);
                    Project project = (Project) projectDao.getById(projectId);
                    setValue(project);

                }
            }

            public String getAsText() {
                Object value = getValue();
                if (value != null) {
                    Project project = (Project) value;
                    return project.getName();
                }
                return null;
            }
        });

        binder.registerCustomEditor(List.class, "users", new CustomCollectionEditor(List.class) {

            protected Object convertElement(Object element) {
                if (element != null) {
                    Integer userId = Integer.parseInt(element.toString());
                    User user = (User) userDao.getById(userId);
                    return user;

                }
                return null;
            }

        });

    }

    @RequestMapping(method = RequestMethod.GET, value = "/tasks/{action}/{id}")
    public String handleAction(@PathVariable Integer id, @PathVariable String action, Model model) {
        Task task = (Task) taskDao.getById(id);
        if (action.equalsIgnoreCase("edit")) {
            model.addAttribute("task", task);
            return "tasks";
        } else if (action.equalsIgnoreCase("delete")) {
            taskDao.delete(task);
        }
        return "redirect:/tasks";
    }

}
