package learning.spring.stepik.intro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("learning.spring.stepik")
public class StepikConfig {

    @Bean
    public Pet getCat() {
        return new Cat();
    }

    @Bean
    public Person getPerson() {
        return new Person(getCat());
    }
}
