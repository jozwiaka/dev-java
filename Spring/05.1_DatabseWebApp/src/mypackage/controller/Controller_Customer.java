package mypackage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mypackage.entity.Customer;
import mypackage.service.Service_Customer;

@Controller
@RequestMapping("/customer")
public class Controller_Customer {
	
	//Spring will scan for a component that implements CustomerDAO interface
	@Autowired
	private Service_Customer service_Customer;
	
//	@PostMapping("/list") //Submits data to given resource
	@GetMapping("/list") //Request data from given resource
	public String listCustomers(Model model)
	{
		List<Customer> customers = service_Customer.getCustomers();
		model.addAttribute("customers", customers);
		return "customers-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model)
	{
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer)
	{
		service_Customer.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id_Customer") int id, Model model)
	{
		Customer customer = service_Customer.getCustomer(id);
	
		//set customer as a model attribute to pre-populate the form
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("id_Customer") int id)
	{
		service_Customer.deleteCustomer(id);
		return "redirect:/customer/list";
	}

}
