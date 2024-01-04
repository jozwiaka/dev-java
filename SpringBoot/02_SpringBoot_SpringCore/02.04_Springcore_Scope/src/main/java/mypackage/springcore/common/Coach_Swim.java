package mypackage.springcore.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Coach_Swim implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Swim::Workout";
    }
}
