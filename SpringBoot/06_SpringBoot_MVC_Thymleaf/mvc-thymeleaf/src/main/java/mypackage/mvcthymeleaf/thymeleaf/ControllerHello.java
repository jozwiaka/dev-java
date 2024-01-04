package mypackage.mvcthymeleaf.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerHello {

    @GetMapping("/hello")
    public String sayHello(Model model){

        model.addAttribute("date", new java.util.Date());

        return "helloworld";
    }
}
