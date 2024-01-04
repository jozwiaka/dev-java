package mypackage.main.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class Aspect_Logging {

	@Before("mypackage.main.aspect.Aspect_Pointcuts.forDaoPackageNoGetterSetter()")
	public void beforeNoGetterSetter()
	{
		System.out.println(">>> Executing @Before noGetterSetter");
	}
}
	
