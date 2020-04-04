/**
 * 
 */
package com.example.ExceptionMailNotify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author Mohamed Ramadan
 *
 */
@Component
@ExceptionMailSender(emails = {"gmail.com"})
public class EmailServiceImpl implements EmailService {

	@Autowired
    public JavaMailSender emailSender;
	public EmailServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void sendSimpleMessage(String to, String subject, String text) {
		
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
		
	}
	@Override
	public Integer anyFunction() {
		System.out.println("anyFunction()");
		return 5 ;
	}

}
