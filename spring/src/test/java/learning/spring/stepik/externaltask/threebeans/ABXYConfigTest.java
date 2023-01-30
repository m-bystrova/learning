package learning.spring.stepik.externaltask.threebeans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ABXYConfigTest {
    AnnotationConfigApplicationContext context;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(ABXYConfig.class);
    }

    @After
    public void close() {
        context.close();
    }

    @Test
    public void testGetMap() {
        AWoIface bean = context.getBean(AWoIface.class);
        System.out.println("injected map = " + bean.getiMap());
    }

    @Test
    public void testGetList() {
        BWoIface bean = context.getBean(BWoIface.class);
        System.out.println("injected list = " + bean.getiList());
    }

}