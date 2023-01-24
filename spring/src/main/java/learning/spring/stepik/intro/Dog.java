package learning.spring.stepik.intro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("dog")
public class Dog implements Pet {
    private static final Logger log = LoggerFactory.getLogger(Dog.class);

    private String name;

    public Dog() {
        log.info("Dog bean is created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String say() {
        return "wow";
    }

    @PostConstruct
    public void init() { //todo: why access modifier can be anything?
        log.info("Class Dog: init method");
    }

    @PreDestroy
    public void destroy() {
        log.info("Class Dog: destroy method");
    }
}
