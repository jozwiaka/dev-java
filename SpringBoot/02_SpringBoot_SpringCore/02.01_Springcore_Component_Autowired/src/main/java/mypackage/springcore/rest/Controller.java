package mypackage.springcore.rest;

import mypackage.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    @Qualifier("coach_Cricket")
    private Coach coach;

//    private Coach coach;
//    @Autowired
//    public void setCoach(Coach coach)
//    {
//        this.coach=coach;
//    }

//    private Coach coach;
//    @Autowired
//    public Controller(@Qualifier("coach_Swim")Coach coach)
//    {
//        this.coach=coach;
//    }

    @GetMapping("/workout")
    public String getDailyWorkout()
    {
        return coach.getDailyWorkout();
    }
}
