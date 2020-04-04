package com.example.ExceptionMailNotify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.example.ExceptionMailNotify.EmailService;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example.ExceptionMailNotify")
public class ExceptionMailNotifyApplication implements CommandLineRunner{
	@Autowired
	EmailService emailService ;
	@Autowired
	AnnotationLogic logic ;
	
	

	public static void main(String[] args) {
	
		SpringApplication.run(ExceptionMailNotifyApplication.class, args);
	}
	 @Override
	    public void run(String... args) {

	        System.out.println("Sending Email...");
	    	
	   	// emailService.sendSimpleMessage("mohamed.ramadan.ahmed1@gmail.com", "Hello", "Hello");
try {
	logic.handleAnnotation();
	emailService.anyFunction();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	        System.out.println("Done");

	    }

}
