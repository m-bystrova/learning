package com.learning.spring.stepik.intro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

    @Test
    public void testBeanScopeSingleton() {
        System.out.println(" ");
        context = new ClassPathXmlApplicationContext("stepikBeanScope.xml");

        Dog myDog = context.getBean("myPet", Dog.class);
        myDog.setName("myDog");

        Dog yourDog = context.getBean("myPet", Dog.class);
        yourDog.setName("yourDog");

        assertEquals(myDog, yourDog);
        assertEquals(myDog.getName(), yourDog.getName());
        assertEquals(myDog.getName(),"yourDog");

    }

    @Test
    public void testBeanScopePrototype() {
        System.out.println(" ");
        context = new ClassPathXmlApplicationContext("stepikBeanScope.xml");

        Cat myCat = context.getBean("myPetCat", Cat.class);
        myCat.setName("myCat");

        Cat yourCat = context.getBean("myPetCat", Cat.class);
        yourCat.setName("yourCat");

        assertNotEquals(myCat, yourCat);
        assertEquals(myCat.getName(),"myCat");
        assertEquals(yourCat.getName(),"yourCat");
    }
}