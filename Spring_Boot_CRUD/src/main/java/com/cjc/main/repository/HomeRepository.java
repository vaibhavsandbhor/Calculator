package com.cjc.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.main.model.Student;

@Repository
public interface HomeRepository extends CrudRepository<Student, Integer>
{

	
	Student findByUnameAndPassword(String un,String ps);
	Student findByUid(int uid);
}
