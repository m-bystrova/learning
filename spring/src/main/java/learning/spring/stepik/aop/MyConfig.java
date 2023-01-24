package learning.spring.stepik.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("learning.spring.stepik.aop")
@EnableAspectJAutoProxy
public class MyConfig {
}
