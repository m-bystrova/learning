package learning.spring.stepik.intro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:stepik.properties")
public class StepikConfig {

    @Bean
    public Pet getCat() {
        return new Cat();
    }

    @Bean
    public Pet getDog() {
        return new Dog();
    }

    @Bean
    public Person getPerson() {
        return new Person(getCat());
    }
}
