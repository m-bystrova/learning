package learning.spring.stepik.aop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LibraryTest {
    AnnotationConfigApplicationContext context;
    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(MyConfig.class);
    }

    @After
    public void close() {
        context.close();
    }

    @Test
    public void testLibraryGetBook() {
        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        uniLibrary.getBook();
        uniLibrary.getMagazine();

        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook();
    }

    @Test
    public void testUniLibraryGetBookWithParam() {
        Book book = context.getBean("book", Book.class);
        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        uniLibrary.getBook(book);

        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook("String");
    }
}
