package learning.spring.stepik.intro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Cat implements Pet {
    private static final Logger log = LoggerFactory.getLogger(Cat.class);

    private String name;

    public Cat() {
        log.info("Cat bean is created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String say() {
        return "mouw";
    }

    public void init() {
        log.info("Class Cat: init method");
    }

    //todo: why if prototype destroy doesn't work:
    //  It is the responsibility of the client code to clean up prototype scoped objects and release any expensive
    //  resources that the prototype bean(s) are holding onto.
    public void destroy() {
        log.info("Class Cat: destroy method");
    }
}
