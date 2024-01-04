package mypackage.springboot0.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerFun {


	@GetMapping("/")
	public String printTime()
	{
		return "Time on server is "+LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout()
	{
		return "call getDailyWorkout";
	}
}
