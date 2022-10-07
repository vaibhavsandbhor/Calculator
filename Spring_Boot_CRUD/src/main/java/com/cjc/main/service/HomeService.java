package com.cjc.main.service;

import com.cjc.main.model.Student;

public interface HomeService {

	public Student saveData(Student s);

	public Student logincheck(String un, String ps);

	public Iterable<Student> displayAll();

	public void deleteData(Student s);

	public Student editData(int uid);

}
