package com.vvs.EmployeeMail.app.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vvs.EmployeeMail.app.main.model.Employee;
import com.vvs.EmployeeMail.app.main.service.EmployeeService;

import ch.qos.logback.core.net.SyslogOutputStream;


@RestController
public class EmployeeController {
	
	
	@Value("${spring.mail.username}")
	String CompanyCompanyGeneratedMail;

	

	@GetMapping("/se")
public String se() {
		return "hiii";
	}
	
	
	@Autowired
	EmployeeService es;
	
		@PostMapping(value="/sendmail",consumes = MediaType.ALL_VALUE)
	public String SendMail(@RequestPart(value="attachment",required = true) MultipartFile file1,
			
			@RequestPart(value="emp",required = true) String emp
			)
	{
		
		try {
			ObjectMapper om=new ObjectMapper();
			
			Employee em=om.readValue(emp, Employee.class);
			
			Employee emp1= new Employee();
			
			emp1.setCompanyGeneratedMail(CompanyCompanyGeneratedMail);
			emp1.setToEmail(em.getToEmail());
			emp1.setSubject(em.getSubject());
			emp1.setTextBody("EmployeeID:"+em.getEmpId()+
					"\n EmployeeName:"+em.getEmpName()+
					"\n EmpolyeeEmail"+em.getEmpEmail()+
			        "\n EmployeeUserName"+em.getUsername()+
			        "\n Paasword"+em.getPassword()+
			        "\n Employee Designation"+em.getDesignation()+
			        "\n Employee Role"+em.getEmpRole()+
			        "\n Project Name"+em.getProjectName());
			
			
			es.sendattachMent(emp1,file1);
			
			
			return "mail sent sucessfully";
			
		}
		
		
			
		 catch (Exception e) {
			// TODO: handle exception
			 
			 
			 e.printStackTrace();
			 return "mail not send";
		
		}
		
	
}
}
