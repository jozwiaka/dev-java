package mypackage.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mypackage.main.dao.AccountDAO;
import mypackage.main.dao.MembershipDAO;

public class Main1 {

	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		Account account = new Account();
		accountDAO.addAccount(account, false);
		membershipDAO.addAccount();
		context.close();
	}
}
