package mypackage2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("mypackage2") //Equal to applicationContext1.xml::<context:component-scan base-package="mypackage2"></context:component-scan>
public class Config_Coach_Tennis {
	
}
