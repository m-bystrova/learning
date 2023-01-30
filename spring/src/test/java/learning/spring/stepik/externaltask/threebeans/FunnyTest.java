package learning.spring.stepik.externaltask.threebeans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FunnyTest {
    AnnotationConfigApplicationContext context;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(FunnyConfig.class);
    }

    @After
    public void close() {
        context.close();
    }

    @Test
    public void testInjectMap() {
        FreeMap bean = context.getBean(FreeMap.class);
        System.out.println("injected map = " + bean.getAbracadabraMap());
    }

    @Test
    public void testInjectList() {
        FreeList bean = context.getBean(FreeList.class);
        System.out.println("injected list = " + bean.getAbracadabraList());
    }

}