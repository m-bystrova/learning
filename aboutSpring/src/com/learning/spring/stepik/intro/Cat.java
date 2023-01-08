package com.learning.spring.stepik.intro;

public class Cat implements Pet {

    private String name;

    public Cat() {
        System.out.println("Cat bean is created");
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
}
