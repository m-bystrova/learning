package learning.spring.stepik.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(public void learning.spring.stepik.aop.UniLibrary.get*())") //pointCut, '*' can use for return type
    public void beforeGetBookAdvice() {
        log.info("beforeGetBookAdvice: trying get book");
    }

    @Before("execution(* *())")
    public void beforeGetAny() {
        log.info("before any method");
    }
}
