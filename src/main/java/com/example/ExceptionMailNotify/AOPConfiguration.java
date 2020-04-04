/**
 * 
 */
package com.example.ExceptionMailNotify;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Mohamed Ramadan
 *
 */
@Configuration
@EnableAspectJAutoProxy
public class AOPConfiguration {
	
	@Bean
    public ExceptionMailSenderAspect myAspect() {
        return new ExceptionMailSenderAspect();
    }

}
