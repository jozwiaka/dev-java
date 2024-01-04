package mypackage2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
public class Config_Coach_Swim {

	@Bean
	public FortuneService fortuneService_Sad()
	{
		return new FortuneService_Sad();
	}
	
	@Bean
	public Coach coach_Swim()
	{
		return new Coach_Swim(fortuneService_Sad());
	}
}
