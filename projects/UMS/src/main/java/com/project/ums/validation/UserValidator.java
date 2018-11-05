package com.project.ums.validation;

import com.project.ums.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

public class UserValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_name", "", "User name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "User email is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_first_name", "", "User first name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_last_name", "", "User last name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "User password is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "", "User address is required");

        if(user.getBirthday() == null)
            errors.rejectValue("birthday", "", "User birthday is required");


        if (!isValidEmail(user.getEmail()) && errors.getErrorCount() < 1) {
            errors.rejectValue("email", "", "Invalid email address");
            return;
        }


    }

    private boolean isValidEmail(String email) {
        String email_pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-.]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(email_pattern);
        return pattern.matcher(email).matches();
    }
}
