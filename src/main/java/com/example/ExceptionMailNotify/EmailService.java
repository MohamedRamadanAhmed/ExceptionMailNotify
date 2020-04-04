/**
 * 
 */
package com.example.ExceptionMailNotify;

/**
 * @author Mohamed Ramadan
 *
 */

public interface EmailService {
	public void sendSimpleMessage(String to, String subject, String text);
	public void anyFunction();
}
