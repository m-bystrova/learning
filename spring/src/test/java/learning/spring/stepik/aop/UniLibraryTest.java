package learning.spring.stepik.aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UniLibraryTest {

    @Test
    public void testAnnotationContext() {
        AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary uniLibrary = applicationContext.getBean("uniLibrary", UniLibrary.class);
        uniLibrary.getBook();
        uniLibrary.getMagazine();
//        assertEquals("take book", library.getBook());

        SchoolLibrary schoolLibrary = applicationContext.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook();

        applicationContext.close();
    }
}