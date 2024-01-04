package mypackage3;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class Controller_Customer {
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder)
	{
//		Pre-process every String from data
//		Remove leading and trailing white space
//		If String only has white space trim it to null
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model)
	{
		model.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer customer,
			BindingResult bindingResult) //Spring will store result in bindingResult
	{
		System.out.println("firstName = |"+customer.getFirstName()+"|");
		System.out.println("lastName = |"+customer.getLastName()+"|");
		
		System.out.println("bindingResult = " + bindingResult + "\n");
		if(bindingResult.hasErrors())
		{
			return "customer-form";
		}
		return "customer-form-result";
	}
}
