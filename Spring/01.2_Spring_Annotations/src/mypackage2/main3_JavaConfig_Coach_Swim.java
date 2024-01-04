package mypackage2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main3_JavaConfig_Coach_Swim {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config_Coach_Swim.class);
		Coach_Swim coach = context.getBean("coach_Swim", Coach_Swim.class); //SportConfig::coach_Swim()
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getEmail());
		System.out.println(coach.getTeam());
		context.close();
	}

}
