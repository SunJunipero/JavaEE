package com.example.taskmanager.validation;

import com.example.taskmanager.model.Task;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class TaskValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Task.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Task task = (Task) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Task name is required");
        if (task.getProject() == null)
            errors.rejectValue("project", "", "Task project is required, choose s project");
        if (task.getUsers() == null || task.getUsers().size() < 1)
            errors.rejectValue("users", "", "Task users is required, choose at least one");

    }
}
