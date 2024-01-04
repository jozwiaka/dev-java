package mypackage3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller_Home {
	
	@RequestMapping("/")
	public String showPage()
	{
		return "home";
	}
}
