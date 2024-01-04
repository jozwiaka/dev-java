package mypackage.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mypackage.entity.Student;

//POJO are automatically converted to JSON

@RestController
@RequestMapping("/api")
public class ControllerStudentRest {

	private List<Student> students;
	
	@PostConstruct
	public void loadData()
	{
		students = new ArrayList<>();
		students.add(new Student("name1","surname1"));
		students.add(new Student("name2","surname2"));
		students.add(new Student("name3","surname3"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		return students;
	}
	
	@GetMapping("/students/{idStudent}")
	public Student getStudent(@PathVariable int idStudent)
	{
		if( idStudent >= students.size() || idStudent<0)
		{
			throw new ExceptionStudentNotFound("Student id not found - "+idStudent);
		}
		return students.get(idStudent);
	}
}
