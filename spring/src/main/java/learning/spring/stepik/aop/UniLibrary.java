package learning.spring.stepik.aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {

    @Override
    public void getBook() {
        System.out.println("take from uni lib");
    }

    public void getMagazine() {
        System.out.println("take magazine from uni lib");
    }
}
