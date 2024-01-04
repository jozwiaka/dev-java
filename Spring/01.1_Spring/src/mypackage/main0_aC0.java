package mypackage;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main0_aC0{

	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext0_TrackCoach.xml");
		TrackCoach theCoach = (TrackCoach) context.getBean("myCoach");
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		context.close();
	}

}
