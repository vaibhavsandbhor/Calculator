package com.vvs.EmployeeMail.app.main.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vvs.EmployeeMail.app.main.model.Employee;
@Service
public class EmployeeService {
	
	@Autowired private JavaMailSender jms;

	public void sendattachMent(Employee emp1, MultipartFile file1) {
		
		
		MimeMessage mm=jms.createMimeMessage();
		try {
			MimeMessageHelper mmh=new MimeMessageHelper(mm,true);
			mmh.setFrom(emp1.getCompanyGeneratedMail());
			mmh.setTo(emp1.getToEmail());
			mmh.setText(emp1.getTextBody());
		     mmh.addAttachment(file1.getOriginalFilename(), file1);
		     
		     jms.send(mm);
		     System.out.println("mail sent sucessfully");
			
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			
			System.out.println("mail not send");
			e.printStackTrace();
		}
		
	}

}
