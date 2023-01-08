package com.learning.spring.stepik.intro;

public class Person {

    private Pet pet;
    private String surname;
    private int age;

//    public Person(Pet pet) {
//        this.pet = pet;
//    }

    public Person() {
        System.out.println("Person bean is created");
    }

    public void setPet(Pet pet) {
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Class Person: set surname");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Class Person: set age");
        this.age = age;
    }

    public String callYourPet(){
        return "Hi, my pet \n" + pet.say();
    }
}
