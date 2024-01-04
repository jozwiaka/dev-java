package mypackage.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class Coach_Swim implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Swim::Workout";
    }
}
