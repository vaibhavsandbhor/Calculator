package com.cjc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.main.model.Student;
import com.cjc.main.service.HomeService;

@Controller
public class HomeController 
{
	@Autowired
	HomeService hs;
    @RequestMapping("/")
	public String prelogin()
	{
		return"login";
	}
    
	@RequestMapping("/registration")
	public String preregister()
	{
		return"registration";
	}
	
	@RequestMapping("/reg")
	public String registerData(@ModelAttribute Student s)
	{
		System.out.println("UserId is-"+s.getUid());
		
	    Student stu=hs.saveData(s);
	    if(stu !=null)
	    {
			return"login";
		
	    }
	    else
	    {
	    	return"registration";
	    }
	}
	
	@RequestMapping("/login")
	public String logincheck(@RequestParam("uname") String un,@RequestParam("password") String ps,Model m)
	{
		System.out.println("username ="+un);
	Student id=	hs.logincheck(un,ps);
	   Iterable<Student> ls= hs.displayAll();
	    System.out.println(ls);
	    if(id !=null)
		{
			m.addAttribute("data", ls);
			return "success";
		}
		else 
		{
			return "login";
		}
		
	}
	
	@RequestMapping("/delete")
	public String deleteData(@ModelAttribute Student s,Model m)
	{
		hs.deleteData(s);
		Iterable<Student> ls= hs.displayAll();
		
		m.addAttribute("data", ls);
		return "success";
		
	}
	
	 @RequestMapping("/edit")
		public String editData(@RequestParam("uid") int uid,Model m)
		{
			Student st=hs.editData(uid);
			if(st!=null)
		{
			m.addAttribute("data", st);
			return"edit";
		
		}
		
		else
		{
			return"success";
		}
			
		}
	   @RequestMapping("/update")
	   public String  updateData(@ModelAttribute Student s,Model m)
	   {
		   Student stu=hs.saveData(s);
		   Iterable<Student> ls= hs.displayAll();
			
			m.addAttribute("data", ls);
			return "success";
		    
	   }
	
}


