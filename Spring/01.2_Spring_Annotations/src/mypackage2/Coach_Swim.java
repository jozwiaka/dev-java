package mypackage2;

import org.springframework.beans.factory.annotation.Value;

public class Coach_Swim implements Coach {

	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public Coach_Swim(FortuneService fortuneService)
	{
		this.fortuneService = fortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return "Coach_Swim::getDailyWorkout()";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	public String getEmail() {
		return email;
	}
	public String getTeam() {
		return team;
	}

	
}
