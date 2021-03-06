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
		String name=invocation.getMethod().getName()+"()";
		System.out.println("Invoking method "+name);
        
		 Object val = null ; 
		 System.out.println(invocation);
        // call the method
		if(invocation != null) {
		        val=invocation.proceed();

		}
        
        // print method is invoked
        System.out.println("Method is invoked.");
        System.out.println(val);
		return val;
	}

}
