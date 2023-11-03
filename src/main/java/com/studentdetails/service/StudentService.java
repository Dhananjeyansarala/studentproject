package com.studentdetails.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentdetails.Dao.StudentDao;
import com.studentdetails.customException.AgeException;
import com.studentdetails.entity.Student;
@Service

public class StudentService {
	@Autowired
	StudentDao sd;

	public String setStudent(Student a) {
		
		return sd.setStudent(a);
	}

	public String setAllStudent(List<Student> a) throws AgeException  {
		List<Student> stud=a.stream().filter(x->x.getAge()<18).collect(Collectors.toList());
		if(stud.isEmpty()) {
		
			return sd.setAllStudent(a);
		}
		else {
			throw new AgeException();
			
		}
	}

	public List<Student> getAllStudent() {
		
		return sd.getAllStudent();
	}

	public Student getStudentById(int a) {
		
		return sd.getStudentById(a);
	}

	public String updateById(int id, String name) {
		
		return sd.updateById(id,name);
	}

	public String deleteById(int id) {
		
		return sd.deleteById(id);
	}

}
