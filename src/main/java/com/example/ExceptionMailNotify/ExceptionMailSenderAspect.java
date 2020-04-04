/**
 * 
 */
package com.example.ExceptionMailNotify;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Mohamed Ramadan
 *
 */
@Aspect
public class ExceptionMailSenderAspect {
	
	@AfterReturning(pointcut = "execution(* com.example.ExceptionMailNotify..*(..)))",returning = "returnVal")
    public void profileAllMethods(JoinPoint joinPoint, Object returnVal) throws Throwable 
    {
        System.out.println("method signature" + joinPoint.getSignature());
    }

}
