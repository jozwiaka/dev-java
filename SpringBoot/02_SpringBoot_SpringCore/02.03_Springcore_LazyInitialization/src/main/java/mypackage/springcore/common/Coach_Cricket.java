package mypackage.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class Coach_Cricket implements Coach{

    Coach_Cricket()
    {
        System.out.println("Constructor : "+getClass());
    }
    @Override
    public String getDailyWorkout() {
        return "Cricket::Workout";
    }
}
