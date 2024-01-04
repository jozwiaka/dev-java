package mypackage.springcore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class Coach_Swim implements Coach{

    Coach_Swim()
    {
        System.out.println("Constructor : " + getClass());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim::Workout";
    }
}
