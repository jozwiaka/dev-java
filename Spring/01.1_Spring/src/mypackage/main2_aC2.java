package mypackage;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main2_aC2 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2_beanScope.xml");
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		System.out.println("Result = " + result);
		System.out.println("Mem location theCoach = " + theCoach);
		System.out.println("Mem location alphaCoach = " + alphaCoach);
		
		context.close();
	}

}
