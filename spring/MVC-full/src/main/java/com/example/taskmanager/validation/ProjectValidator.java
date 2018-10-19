package com.example.taskmanager.validation;

import com.example.taskmanager.model.Project;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProjectValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return Project.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Project name is required");
    }
}
