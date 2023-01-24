package learning.spring.stepik.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {

    @Value("name for book")
    private String name;

    public String getName(){
        return name;
    }
}
