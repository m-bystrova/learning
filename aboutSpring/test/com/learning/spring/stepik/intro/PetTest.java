package com.learning.spring.stepik.intro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class PetTest {
    ClassPathXmlApplicationContext context;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("stepik.xml");
    }

    @After
    public void close() {
        context.close();
    }

    @Test
    public void testDogSay() {
        Pet dog = new Dog();
        Pet cat = new Cat();
        assertEquals("wow", dog.say());
        assertEquals("mouw", cat.say());
    }

    @Test
    public void testConfigWithXml() {
        Pet pet = context.getBean("myPet", Pet.class);
        assertEquals("wow", pet.say());
    }

    @Test
    public void testPerson() {
        Person person = context.getBean("myPerson", Person.class);
        assertEquals("Hi, my pet \nwow", person.callYourPet());
    }

    @Test
    public void testFieldsFromPerson() {
        Person person = context.getBean("myPerson", Person.class);
        assertEquals(person.getSurname(), "Surname");
        assertEquals(person.getAge(), 1);
    }
}