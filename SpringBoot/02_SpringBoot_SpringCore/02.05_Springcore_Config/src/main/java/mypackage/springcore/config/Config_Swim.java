package mypackage.springcore.config;

import mypackage.springcore.common.Coach;
import mypackage.springcore.common.Coach_Swim;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config_Swim {

    @Bean("beanCoach_Swim")
    public Coach createSwimCoach(){
        return new Coach_Swim();
    }

}
