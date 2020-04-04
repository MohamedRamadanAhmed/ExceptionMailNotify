/**
 * 
 */
package com.example.ExceptionMailNotify;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Mohamed Ramadan
 *
 */

@Component
public class SimplePoinCut extends DynamicMethodMatcherPointcut {
	
	 @Override
	    public ClassFilter getClassFilter() {
	        return new ClassFilter(){
	            @Override
	            public boolean matches(Class<?> cls)
	            {
	            	for (Annotation n : cls.getAnnotations())
	            	{
	            		if(n.annotationType() == ExceptionMailSender.class)
	            			return true;
	            	}
					return false;
	                
	            }
	        };
	    }

	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		// TODO Auto-generated method stub
		return true;
	}

}
