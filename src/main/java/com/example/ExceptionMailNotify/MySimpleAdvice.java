/**
 * 
 */
package com.example.ExceptionMailNotify;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @author Mohamed Ramadan
 *
 */
@Component
public class MySimpleAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String name=invocation.getMethod().getName()+"("+invocation.getArguments()[0]+")";
		System.out.println("Invoking method "+name);
        
        // call the method
       Object val=invocation.proceed();
        
        // print method is invoked
        System.out.println("Method is invoked.");
		return val;
	}

}
