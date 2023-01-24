package learning.spring.stepik.aop;

import org.springframework.stereotype.Component;

@Component
public class Library {

    public void getBook(){
        System.out.println("take book");
    }
}
