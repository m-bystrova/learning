package learning.spring.stepik.externaltask.threebeans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

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
        Map<String, Abracadabra> abracadabraMap = bean.getAbracadabraMap();
        assertEquals(2, abracadabraMap.size());
        List<Map.Entry<String, Abracadabra>> result = abracadabraMap.entrySet()
            .stream()
            .filter(e -> DefunctAbracadabra.class.equals(e.getValue().getClass()) || ExistingAbracadabra.class.equals(e.getValue().getClass()))
            .collect(Collectors.toList());
        assertEquals(2, result.size());
    }

    @Test
    public void testInjectList() {
        FreeList bean = context.getBean(FreeList.class);
        List<Abracadabra> abracadabraList = bean.getAbracadabraList();
        assertEquals(2, abracadabraList.size());
        List<Abracadabra> result = abracadabraList.stream()
            .filter(e -> DefunctAbracadabra.class.equals(e.getClass()) || ExistingAbracadabra.class.equals(e.getClass()))
            .collect(Collectors.toList());
        assertEquals(2, result.size());
    }
}