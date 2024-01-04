package mypackage.main.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class Aspect_Logging2 {

	@Before("mypackage.main.aspect.Aspect_Pointcuts.forDaoPackageNoGetterSetter()")
	public void beforeNoGetterSetter2()
	{
		System.out.println(">>> Executing @Before noGetterSetter 2");
	}
}
	
