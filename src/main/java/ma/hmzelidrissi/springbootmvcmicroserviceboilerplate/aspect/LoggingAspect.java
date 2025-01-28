package ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("within(ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.service..*)")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        String className = signature.getDeclaringType().getSimpleName();

        log.info("Starting execution of {}.{} with parameters: {}",
                className, methodName, joinPoint.getArgs());

        long startTime = System.currentTimeMillis();

        try {
            Object result = joinPoint.proceed();

            log.info("Completed execution of {}.{} in {}ms",
                    className, methodName, System.currentTimeMillis() - startTime);

            return result;
        } catch (Exception e) {
            log.error("Error in {}.{} after {}ms",
                    className, methodName, System.currentTimeMillis() - startTime, e);
            throw e;
        }
    }
}