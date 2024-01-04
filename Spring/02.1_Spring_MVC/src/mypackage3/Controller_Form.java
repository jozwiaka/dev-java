package mypackage3;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/form")
public class Controller_Form {

	@RequestMapping("/showForm")
	public String showForm()
	{
		return "form";
	}
	
//	@RequestMapping("/processForm")
//	public String processForm(HttpServletRequest request, Model model)
//	{
//		String name = request.getParameter("studentName");
//		name = name.toUpperCase();
//		String result = "Name = " + name;
//		model.addAttribute("message", result); //name, value
//		return "form-result";
//	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@RequestParam("studentName") String name,
			Model model)
	{
		name = name.toUpperCase();
		String result = "Name = " + name;
		model.addAttribute("message", result); //name, value
		return "form-result";
	}
	
	@RequestMapping("/processForm2")
	public String processForm2(
			@RequestParam("studentName") String name,
			Model model)
	{
		name = name.toUpperCase();
		String result = "Name2 = " + name;
		model.addAttribute("message", result); //name, value
		return "form-result";
	}
}
