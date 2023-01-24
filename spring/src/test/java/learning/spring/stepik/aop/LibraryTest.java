package learning.spring.stepik.aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LibraryTest {

    @Test
    public void testAnnotationContext() {
        AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(MyConfig.class);
        Library library = applicationContext.getBean("library", Library.class);
        library.getBook();
//        assertEquals("take book", library.getBook());

        applicationContext.close();
    }
}