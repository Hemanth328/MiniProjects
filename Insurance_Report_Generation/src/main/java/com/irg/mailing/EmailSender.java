package com.irg.mailing;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailSender {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendmail(String subject, String body, String to, File file) {
		
		try {
			
			MimeMessage mimeMsg = mailSender.createMimeMessage();
			
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true);
			
			helper.setSubject(subject);
			helper.setText(body, true);
			helper.setTo(to);
			
			helper.addAttachment("Citizen-Plans Info", file);
			
			mailSender.send(mimeMsg);
		}
		catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}

}
