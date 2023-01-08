package com.learning.spring.stepik.intro;

public class Dog implements Pet {

    public Dog() {
        System.out.println("Dog bean is created");
    }

    @Override
    public String say(){
        return "wow";
    }
}
