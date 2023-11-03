package com.studentdetails.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentdetails.customException.AgeException;
import com.studentdetails.entity.Student;
import com.studentdetails.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService ss;
	static Logger log=Logger.getLogger(StudentController.class);
	@PostMapping("/set")
	public String setStudent(@RequestBody Student a) {
		PropertyConfigurator.configure("dj.properties");
		log.info(ss.setStudent(a));
		return ss.setStudent(a);
	}
	@PostMapping("/setAll")
	public String  setAllStudent(@RequestBody List<Student> a) throws AgeException  {
		return ss.setAllStudent(a);
	}
	@GetMapping("/getAll")
	public List<Student> getAllStudent() {
		return ss.getAllStudent();
	}
	static Logger log1=Logger.getLogger(StudentController.class);
	@GetMapping("/getStudentById/{a}")
	public Student getStudentById(@PathVariable int a) {
		PropertyConfigurator.configure("dj.properties");
		log1.warn(ss.getStudentById(a));
		return ss.getStudentById(a);
	}
	@PutMapping("/update/{id}/{name}")
	public String updateById(@PathVariable int id,@PathVariable String name) {
		return ss.updateById(id,name);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		return ss.deleteById(id);
	}
	

}
