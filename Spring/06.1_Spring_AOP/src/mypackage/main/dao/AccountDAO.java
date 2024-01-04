package mypackage.main.dao;

import org.springframework.stereotype.Component;

import mypackage.main.Account;

@Component
public class AccountDAO {
	public void addAccount(Account account, boolean bool)
	{
		System.out.println(getClass()+" :addAccount");
	}
}
