package mypackage.service;

import java.util.List;

import mypackage.entity.Customer;

public interface Service_Customer {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
