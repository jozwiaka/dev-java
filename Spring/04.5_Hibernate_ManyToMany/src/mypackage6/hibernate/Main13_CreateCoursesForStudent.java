package mypackage6.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mypackage6.hibernate.entity.Course;
import mypackage6.hibernate.entity.Instructor;
import mypackage6.hibernate.entity.InstructorDetail;
import mypackage6.hibernate.entity.Review;
import mypackage6.hibernate.entity.Student;

public class Main13_CreateCoursesForStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
		
			session.beginTransaction();
			
			int id_student = 1;
			Student student = session.get(Student.class, id_student);
			System.out.println("Student = " + student);
			System.out.println("Courses = " + student.getCourses());
			
			
			Course course1 = new Course("CourseStudent1");
			Course course2 = new Course("CourseStudent2");
			course1.addStudent(student);
			course2.addStudent(student);
			
			System.out.println("\nSaving courses ...");
			session.save(course1);
			session.save(course2);
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally
		{
			session.close();
			factory.close();
		}
								
	}

}
