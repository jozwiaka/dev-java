package mypackage.springcore.rest;

import mypackage.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Coach coach1;
    private Coach coach2;

    @Autowired
    public Controller(@Qualifier("coach_Swim")Coach coach1, @Qualifier("coach_Swim")Coach coach2)
    {
        this.coach1=coach1;
        this.coach2=coach2;
    }

    @GetMapping("/check")
    public String check()
    {
        return "coach1 == coach2 -> "+(coach1==coach2);
    }
}
