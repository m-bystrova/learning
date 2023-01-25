package learning.spring.stepik.intro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

//@Component("person")
public class Person {
    private static final Logger log = LoggerFactory.getLogger(Person.class);

    //    @Autowired
    //    @Qualifier("cat")
    private Pet pet;
    @Value("${person.surname}")
    private String surname;
    @Value("${person.age}")
    private int age;

    //    @Autowired
    public Person(Pet pet) {
        log.info("Person bean is created");
        this.pet = pet;
    }

    //    public Person() {
    //        log.info("Person bean is created");
    //    }

    //    @Autowired
    public void setPet(Pet pet) {
        log.info("Class Person: set pet");
        this.pet = pet;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        log.info("Class Person: set surname");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        log.info("Class Person: set age");
        this.age = age;
    }

    public String callYourPet() {
        return "Hi, my pet \n" + pet.say();
    }
}
