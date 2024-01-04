package mypackage.main.dao;

import org.springframework.stereotype.Component;

import mypackage.main.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public void addAccount(Account account, boolean bool)
	{
		System.out.println(getClass()+" :addAccount");
	}

	public String getName() {
		System.out.println(getClass()+": getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+":getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	
}
