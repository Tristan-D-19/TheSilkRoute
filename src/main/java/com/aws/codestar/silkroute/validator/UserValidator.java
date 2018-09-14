package com.aws.codestar.silkroute.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.service.UserService;

@Component
public class UserValidator implements Validator {

	
	@Autowired
    private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		 User user = (User) o;

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
	        if (user.getEmail().length() < 6 || user.getEmail().length() > 32) {
	            errors.rejectValue("email", "Size.userForm.email");
	        }
	        if (userService.findUserByEmail(user.getEmail()) != null) {
	            errors.rejectValue("email", "Duplicate.userForm.email");
	        }

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
	        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
	            errors.rejectValue("password", "Size.userForm.password");
	        }

	        if (!user.getPasswordConfirm().equals(user.getPassword())) {
	            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
	        }

		
	}

	
}
