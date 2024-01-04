package mypackage.main.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspect_Logging {

//	@Before("execution(public void addAccount())")
//	@Before("execution(public void add*())")
//	@Before("execution(* void add*())")
//	@Before("execution(void add*())")
//	@Before("execution(* add*())")
//	@Before("execution(public void mypackage.main.dao.AccountDAO.addAccount())")
//	@Before("execution(* add*(mypackage.main.Account))")
//	@Before("execution(* add*(mypackage.main.Account, ..))") //".." = wildcard = any args
//	@Before("execution(* add*(..))") //".." = wildcard = any args
	@Before("execution(* mypackage.main.dao.*.*(..))") //any function in package
	public void beforeAddAcountAdvice() {
		System.out.println("\nExecuting @Before advice on addAccount()");
	}
}
