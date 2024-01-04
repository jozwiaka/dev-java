package mypackage.springboot0;

import org.springframework.boot.SpringApplication; //Bootstrap Spring Boot application
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication{"otherpackage.rest", "otherpackage.controller"})
@SpringBootApplication //scan root package and its subpackages
//1) @EnableAutoConfiguration = Enables Spring Boot's auto configuration support
//2) @ComponentScan = Component scaning of current package (mypackage.springboot0) and subpackages (e.g. mypackage.springboot0.rest)
//3) @Configuration = Able to register extra beans with @Bean or import other configuration classes
public class SpringBoot0Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot0Application.class, args);
	}

}
