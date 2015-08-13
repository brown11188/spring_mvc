package huy.bui.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import huy.bui.model.Employee;

public class Validator implements org.springframework.validation.Validator {

	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		return Employee.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name", "Field name is required");
	}

}
