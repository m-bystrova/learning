package learning.spring.stepik.aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UniLibraryTest {

    @Test
    public void testAnnotationContext() {
        AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(MyConfig.class);

        Book book = applicationContext.getBean("book", Book.class);
        UniLibrary uniLibrary = applicationContext.getBean("uniLibrary", UniLibrary.class);
        uniLibrary.getBook();
        uniLibrary.getMagazine();
        uniLibrary.getBook(book);
//        assertEquals("take book", library.getBook());

        SchoolLibrary schoolLibrary = applicationContext.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook();


        applicationContext.close();
    }
}