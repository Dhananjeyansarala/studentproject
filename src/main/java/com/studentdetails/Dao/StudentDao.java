package com.studentdetails.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studentdetails.Repository.StudentRepository;
import com.studentdetails.entity.Student;
@Repository
public class StudentDao {
	@Autowired
	StudentRepository sr;

	public String setStudent(Student a) {
		sr.save(a);
	 return "saved";
	}

	public String setAllStudent(List<Student> a) {
		sr.saveAll(a);
		
		return "Saved successfully";
	}

	public List<Student> getAllStudent() {
		
		return sr.findAll();
	}

	public Student getStudentById(int a) {
		
		return sr.findById(a).get();
	}

	public String updateById(int id, String name) {
		Student stud=sr.findById(id).get();
		stud.setName(name);
		sr.save(stud);
		
		return "updated";
	}

	public String deleteById(int id) {
		sr.deleteById(id);
		
		return "Deleted";
	}

}
