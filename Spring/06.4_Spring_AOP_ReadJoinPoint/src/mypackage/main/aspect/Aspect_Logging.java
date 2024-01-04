package mypackage.main.aspect;

import java.util.Objects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import mypackage.main.Account;

@Aspect
@Component
@Order(1)
public class Aspect_Logging {

	@Before("mypackage.main.aspect.Aspect_Pointcuts.forDaoPackageNoGetterSetter()")
	public void beforeNoGetterSetter(JoinPoint joinPoint)
	{
		System.out.println(">>> Executing @Before noGetterSetter");
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: "+ methodSignature);
		
		Object[] args = joinPoint.getArgs();
		for (Object arg : args)
		{
			System.out.println("Arg:" + arg);
			if(arg instanceof Account)
			{
				Account account = (Account) arg;
				
				System.out.println(account.getName());
				System.out.println(account.getLvl());
			}
		}
		
	}
}
	
