import learning.spring.stepik.intro.Cat;
import learning.spring.stepik.intro.Dog;
import learning.spring.stepik.intro.Person;
import learning.spring.stepik.intro.Pet;
import learning.spring.stepik.intro.StepikConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
    public void testPetsSay() {
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

    @Ignore("deleted name")
    @Test
    public void testPerson() {
        Person person = context.getBean("myPerson", Person.class);
        assertEquals("Hi, my pet \nwow", person.callYourPet());
    }

    @Ignore("deleted name")
    @Test
    public void testFieldsFromPerson() {
        Person person = context.getBean("myPerson", Person.class);
        assertEquals("Surname", person.getSurname());
        assertEquals(1, person.getAge());
    }

    @Test
    public void testBeanScopeSingleton() {
        context = new ClassPathXmlApplicationContext("stepikBeanScope.xml");

        Dog myDog = context.getBean("myPet", Dog.class);
        myDog.setName("myDog");

        Dog yourDog = context.getBean("myPet", Dog.class);
        yourDog.setName("yourDog");

        assertEquals(myDog, yourDog);
        assertEquals(myDog.getName(), yourDog.getName());
        assertEquals("yourDog", myDog.getName());
    }

    @Test
    public void testBeanScopePrototype() {
        context = new ClassPathXmlApplicationContext("stepikBeanScope.xml");

        Cat myCat = context.getBean("myPetCat", Cat.class);
        myCat.setName("myCat");

        Cat yourCat = context.getBean("myPetCat", Cat.class);
        yourCat.setName("yourCat");

        assertNotEquals(myCat, yourCat);
        assertEquals("myCat", myCat.getName());
        assertEquals("yourCat", yourCat.getName());
    }

    @Ignore("deleted annotation")
    @Test
    public void testConfigurationWithAnnotation() {
        context = new ClassPathXmlApplicationContext("stepikScan.xml");

        Cat catBean = context.getBean("cat", Cat.class);
        assertEquals("mouw", catBean.say());

        Person personBean = context.getBean("person", Person.class);
        assertEquals("Hi, my pet \nmouw", personBean.callYourPet());
    }

    @Ignore("commented @Value")
    @Test
    public void testAnnotationValue() {
        context = new ClassPathXmlApplicationContext("stepikScan.xml");

        Person personBean = context.getBean("person", Person.class);
        assertEquals("Surname", personBean.getSurname());
        assertEquals(1, personBean.getAge());
    }

    @Ignore("deleted name")
    @Test
    public void testScopeValue() {
        context = new ClassPathXmlApplicationContext("stepikSimpleScope.xml");

        Dog myDog = context.getBean("dog", Dog.class);
        assertEquals("wow", myDog.say());
    }

    @Test
    public void testAnnotationContext() {
        AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(StepikConfig.class);
        Dog myDog = applicationContext.getBean("getDog", Dog.class);
        assertEquals("wow", myDog.say());

        Person personBean = applicationContext.getBean("getPerson", Person.class);
        assertEquals("Hi, my pet \nmouw", personBean.callYourPet());
        assertEquals("Surname", personBean.getSurname());
        assertEquals(1, personBean.getAge());

        applicationContext.close();
    }
}
