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
		account.setName("nameAccount");
		account.setLvl("lvlAccount");
		accountDAO.addAccount(account, false);
		accountDAO.setName("name");
		accountDAO.setServiceCode("code");
		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();
		
		membershipDAO.addAccount();
		context.close();
	}
}
