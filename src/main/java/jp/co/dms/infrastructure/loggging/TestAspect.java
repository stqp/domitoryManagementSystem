package jp.co.dms.infrastructure.loggging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

    @AfterReturning(value = "execution(* jp.co.dms.interfaces.rentalproperty.rest.RentalPropertyController.*(..))", returning = "r")
    public void handler(Object r) {
        ch.qos.logback.classic.Logger logger = (Logger) LoggerFactory.getLogger(TestAspect.class);
        logger.setLevel(Level.WARN);
        //logger.info("INFO LOG!!  Logger Class=" + logger.getClass());
    }
}
