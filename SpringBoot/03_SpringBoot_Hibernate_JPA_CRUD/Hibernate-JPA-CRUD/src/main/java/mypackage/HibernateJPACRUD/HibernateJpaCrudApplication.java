package mypackage.HibernateJPACRUD;

import mypackage.HibernateJPACRUD.dao.StudentDAO;
import mypackage.HibernateJPACRUD.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateJpaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) //Executed after Spring Beans have been loaded
	{
		//lambda expression; custom code
		return runner -> {
//			Integer id = createStudent(studentDAO);
//			updateStudent(studentDAO, id);
//			readStudent(studentDAO, id);
//			deleteStudent(studentDAO, id);
//			queryReadAllStudents(studentDAO);
//			queryReadStudentByLastName(studentDAO, "Jozwiak");
			createMultipleStudents(studentDAO);
//			deleteAllStudents(studentDAO);

		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		for (int i = 1; i<=10; i++)
		{
			Student student = new Student("name"+i, "surname"+i, "email"+i);
			studentDAO.save(student);
		}
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		studentDAO.deleteAll();
	}

	private void deleteStudent(StudentDAO studentDAO, Integer id) {
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO, Integer id) {

		Student student = studentDAO.findById(id);
		student.setFirstName("Changed");
		studentDAO.update(student);
	}

	private void queryReadStudentByLastName(StudentDAO studentDAO, String lastName) {
		List<Student> students = studentDAO.findByLastName(lastName);
		printStudents(students);
	}

	private void queryReadAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		printStudents(students);
	}

	private static void printStudents(List<Student> students) {
		for (Student student : students)
		{
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO, Integer id) {

		Student student = studentDAO.findById(id);
		System.out.println(student);
	}

	private Integer createStudent(StudentDAO studentDAO) {

		Student student = new Student("Hilbert", "Jozwiak", "bulbertjozwiak@gmail.com");
		studentDAO.save(student);
		return student.getId();
	}


}
