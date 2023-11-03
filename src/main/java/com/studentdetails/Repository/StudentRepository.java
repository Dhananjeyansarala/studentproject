package com.studentdetails.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentdetails.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	

}
