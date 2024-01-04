package mypackage.main.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Aspect_Pointcuts {
	@Pointcut("execution(* mypackage.main.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* mypackage.main.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* mypackage.main.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
}
