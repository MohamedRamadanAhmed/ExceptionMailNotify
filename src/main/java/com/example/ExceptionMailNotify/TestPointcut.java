/**
 * 
 */
package com.example.ExceptionMailNotify;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Mohamed Ramadan
 *
 */
public class TestPointcut {
	
	@Pointcut(value = "execution(* com.example.ExceptionMailNotify..*(..)))")
	public void firstPointcut() {}

}
