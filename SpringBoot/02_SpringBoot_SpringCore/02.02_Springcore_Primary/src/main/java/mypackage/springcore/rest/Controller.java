package mypackage.springcore.rest;

import mypackage.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
//    @Qualifier("coach_Swim")
    private Coach coach;

    @GetMapping("/workout")
    public String getDailyWorkout()
    {
        return coach.getDailyWorkout();
    }
}
