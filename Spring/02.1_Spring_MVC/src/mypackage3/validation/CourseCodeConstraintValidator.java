package mypackage3.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefix = courseCode.value();
	}

	@Override
	public boolean isValid(
			String code /*HTML Form Data entered by the user*/,
			ConstraintValidatorContext constraintValidatorContext /*Additional error message*/
			)
	{
		boolean result;
		if (code != null)
		{
			result = code.startsWith(coursePrefix);
		}
		else
		{
			result = true;
		}
		return result;
	}


}
