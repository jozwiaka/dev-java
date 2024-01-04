package mypackage3;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import mypackage3.validation.CourseCode;

public class Customer {

	private String firstName;
	
	@NotNull(message="NotNull")
	@Size(min=1, message="Size:min=1")
	private String lastName;

	@NotNull(message="NotNull")
	@Min(value=0, message="must be >=0")
	@Max(value=10, message="must be <=10")
	private Integer number;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chars/digits")
	private String postalCode;
	
//	@CourseCode(value="AJ", message="Must start with AJ")
	@CourseCode //My annotation has support for defaults
	private String courseCode;
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
