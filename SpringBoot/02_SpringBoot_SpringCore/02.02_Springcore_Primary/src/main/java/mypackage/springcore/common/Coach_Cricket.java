package mypackage.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class Coach_Cricket implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Cricket::Workout";
    }
}
