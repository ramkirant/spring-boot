package com.ramlearning.customer.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("execution(* com.ramlearning.customer.*.*.*(..))")
    public Object loggingAdvice(ProceedingJoinPoint pj)
            throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        String methodName = pj.getSignature().getName();
        String className = pj.getTarget().getClass().toString();

        Object[] array = pj.getArgs();

        log.info("Entering {} class, {} method, with request: {}",
                className, methodName, mapper.writeValueAsString(array));

        Object response = pj.proceed();

        log.info("Leaving {} class, {} method, with response: {} ",
                className, methodName,
                mapper.writeValueAsString(response));

        return response;
    }
}
