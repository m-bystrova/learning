package learning.spring.stepik.aop;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary{

    @Override
    public void getBook() {
        System.out.println("take from school lib");
    }

    public void getBook(String bookName) {
        System.out.println("take: " + bookName);
    }
}
