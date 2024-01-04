package mypackage;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	private String email;
	private String team;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("CricketCoach - set email = "+email);
		this.email = email;
	}
	
	public String getTeam() {
		System.out.println("CricketCoach - set team = "+email);
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public CricketCoach()
	{
		System.out.println("CricketCoach constructor - no args");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach - set fortuneService = "+fortuneService);
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "CricketCoach - getDailyWorkout";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
