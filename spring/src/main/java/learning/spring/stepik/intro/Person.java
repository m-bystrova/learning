package learning.spring.stepik.intro;

public class Person {

    private final Pet pet;

    public Person(Pet pet) {
        this.pet = pet;
    }

    public String callYourPet(){
        return "Hi, my pet \n" + pet.say();
    }
}
