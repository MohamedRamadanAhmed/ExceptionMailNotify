/**
 * 
 */
package com.example.ExceptionMailNotify;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Mohamed Ramadan
 *
 */
@Component
public class AnnotationLogic {
	@Autowired
	ApplicationContext context;
	@Autowired
	List<Object> all;
	@Autowired
	SimplePoinCut pointcut;
	@Autowired
	MySimpleAdvice advice;
	
	public void handleAnnotation() throws Exception {
		int i = 0;

		for (Object object : all) {
			Class<?> clazz = object.getClass();
			 System.out.println("All classes : " + clazz.getName());

			if (clazz.isAnnotationPresent(ExceptionMailSender.class)) {
//	    		for (Method method : clazz.getMethods()) {
//	    	    	method.setAccessible(true);
//	    	        
//	    	        	System.out.println("class name : "+ clazz.getName() + "  method " + i +" : "+ method.getName());
//	    	            
//	    	        i++;
//	    	    }	
				Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
				ProxyFactory pf = new ProxyFactory();
				pf.setTargetClass(clazz);
				pf.addAdvisor(advisor);
				Class<?> c = pf.getTargetClass();
				BeanDefinitionRegistry factory = 
						   (BeanDefinitionRegistry) context.getAutowireCapableBeanFactory();
				char chrs[] = clazz.getSimpleName().toCharArray();
				chrs[0] = Character.toLowerCase(chrs[0]);
				String s = new String(chrs);
				factory.removeBeanDefinition(s);
				for(String g :factory.getBeanDefinitionNames()) {
					System.out.println("bean : "+g);
				}
				System.out.println("factory.containsBeanDefinition(s) : "+s+" "+factory.containsBeanDefinition(s));
				

				//context.getAutowireCapableBeanFactory().createBean(c);

			}
		}

	}

}
