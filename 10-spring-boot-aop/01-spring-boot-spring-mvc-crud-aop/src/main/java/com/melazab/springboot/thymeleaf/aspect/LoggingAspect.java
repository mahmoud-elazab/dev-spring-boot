package com.melazab.springboot.thymeleaf.aspect;

import jakarta.annotation.PostConstruct;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* com.melazab.springboot.thymeleaf.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.melazab.springboot.thymeleaf.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.melazab.springboot.thymeleaf.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJointPoint){
        // display method that is called
        String theMethod = theJointPoint.getSignature().toShortString();
        myLogger.info("===> in @Before: calling method: "+ theMethod);

        // display the arguments to the method

        // get the arguments
        Object[] args = theJointPoint.getArgs();

        // loop on the arguments and display them
        for(Object tempArg: args){
            myLogger.info("===> argument: " + tempArg);
        }

    }

    // add @AfterReturning advic
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint theJointPoint, Object theResult){
        // display method that is returned
        String theMethod = theJointPoint.getSignature().toShortString();
        myLogger.info("===> in @AfterReturning: from method: "+ theMethod);

        // display data retuned
        myLogger.info("===> result: " + theResult);

    }

}
