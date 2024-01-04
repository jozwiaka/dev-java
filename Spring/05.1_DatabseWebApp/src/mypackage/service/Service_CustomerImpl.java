package mypackage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mypackage.dao.CustomerDAO;
import mypackage.entity.Customer;

@Service
public class Service_CustomerImpl implements Service_Customer {

	@Autowired
	@Qualifier("customerDAOImpl") //Added by me - fix strange error concerned with customerDAO_Default (probably cache is not cleared)
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	//Spring will wrap method in transaction
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {

		customerDAO.deleteCustomer(id);
	}

}
