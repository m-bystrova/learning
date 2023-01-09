package learning.spring.stepik.intro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Person {
    private static final Logger log = LoggerFactory.getLogger(Person.class);

    private Pet pet;
    private String surname;
    private int age;

    public Person() {
        log.info("Person bean is created");
    }

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

    public String callYourPet(){
        return "Hi, my pet \n" + pet.say();
    }
}
