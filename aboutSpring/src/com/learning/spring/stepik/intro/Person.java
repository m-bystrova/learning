package com.learning.spring.stepik.intro;

public class Person {

    private Pet pet;

//    public Person(Pet pet) {
//        this.pet = pet;
//    }

    public Person() {
        System.out.println("Person is created");
    }

    public void setPet(Pet pet) {
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    public String callYourPet(){
        return "Hi, my pet \n" + pet.say();
    }
}
