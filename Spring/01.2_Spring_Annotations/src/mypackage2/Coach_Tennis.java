package mypackage2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("customComponentName")
@Component
// @Scope("prototype") //Singleton by default
public class Coach_Tennis implements Coach {

	// Autowired3_Variable
	@Autowired
	@Qualifier("fortuneService_Random") // Bean name to inject
	private FortuneService fortuneService;

	public Coach_Tennis() {
		System.out.println("Coach_Tennis::Coach_Tennis()");
	}

	@PostConstruct
	public void onStartup() {
		System.out.println("Coach_Tennis::onStartup()");
	}

	@PreDestroy
	public void onCleanup() {
		System.out.println("Coach_Tennis::onCleanup()");

	}

	// Autowired2_Setter
	// @Autowired
	// public void setFortuneService(FortuneService fortuneService)
	// {
	// System.out.println("Coach_Tennis::setFortuneService(FortuneService)");
	// this.fortuneService = fortuneService;
	// }

	// Autowired1_Constructor
	// //Spring will scan for a component that implements FortuneService interface
	// //HappyFortuneService meets the requirement
	// @Autowired
	// public Coach_Tennis(FortuneService fortuneService)
	// {
	// System.out.println("Coach_Tennis::Coach_Tennis(FortuneService)");
	// this.fortuneService=fortuneService;
	// }

	@Override
	public String getDailyWorkout() {
		return "Coach_Tennis::getDailyWorkout()";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
