package com.vvs.EmployeeMail.app.main.model;

import lombok.Data;

@Data
public class Employee {
	
	
	private Integer empId;
	private String empName;
	private  String empEmail;
	private String username;
	private String password;
	private String designation;
	private String empRole;
	private String projectName;
	
	
	private String CompanyGeneratedMail;
	private String toEmail;
	private String textBody;
	private String subject;

}
