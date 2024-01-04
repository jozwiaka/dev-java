package mypackage.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //Spring Pure Java Configuration
@EnableAspectJAutoProxy //Spring AOP Proxy Support
@ComponentScan("mypackage")
public class Config {
	
}
