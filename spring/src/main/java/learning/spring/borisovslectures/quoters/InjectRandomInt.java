package learning.spring.borisovslectures.quoters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt { //todo:?
    int min();
    int max();
}
