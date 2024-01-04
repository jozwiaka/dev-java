package mypackage.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//1) REST Client -> /test/hello -> REST Service
//2) REST Service -> Hello World! -> REST Client

@RestController
@RequestMapping("/test")
public class ControllerRest {

	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello World!";
	}
}
