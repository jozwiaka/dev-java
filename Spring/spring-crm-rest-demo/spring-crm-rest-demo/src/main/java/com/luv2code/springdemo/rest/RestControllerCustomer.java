package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class RestControllerCustomer {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers()
	{
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{idCustomer}")
	public Customer getCustomer(@PathVariable int idCustomer)
	{
		Customer customer = customerService.getCustomer(idCustomer);
		if(customer == null)
		{
			throw new ExceptionCustomerNotFound("Customer id = "+idCustomer +" not found");
		}
		return customer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		customer.setId(0);
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@DeleteMapping("/customers/{idCustomer}")
	public String deleteCustomer(@PathVariable int idCustomer)
	{
		Customer customer = customerService.getCustomer(idCustomer);
		if(customer==null)
		{
			throw new ExceptionCustomerNotFound("Customer id = "+idCustomer +" not found");
		}
		customerService.deleteCustomer(idCustomer);
		return "Deleted customer id = "+idCustomer;
	}
	
}
