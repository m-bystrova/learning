package learning.spring.stepik.aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {

    @Override
    public void getBook() {
        System.out.println("take from uni lib");
    }

    public void getBook(Book bookName) {
        System.out.println("take: " + bookName.getName());
    }

    public void getMagazine() {
        System.out.println("take magazine from uni lib");
    }
}
