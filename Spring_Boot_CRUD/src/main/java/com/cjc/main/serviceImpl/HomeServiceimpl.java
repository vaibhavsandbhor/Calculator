package com.cjc.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Student;
import com.cjc.main.repository.HomeRepository;
import com.cjc.main.service.HomeService;

@Service
public class HomeServiceimpl implements HomeService
{

	@Autowired
	HomeRepository hr;
	@Override
	public Student saveData(Student s) {
		
		return hr.save(s);
	}
	@Override
	public Student logincheck(String un, String ps) {
		
	
		return hr.findByUnameAndPassword(un, ps);
	}
	@Override
	public Iterable<Student> displayAll() {
	
		return hr.findAll();
	}
	@Override
	public void deleteData(Student s) {
		hr.delete(s);
		
	}
	@Override
	public Student editData(int uid) {
		
		return hr.findByUid(uid);
	}

}
