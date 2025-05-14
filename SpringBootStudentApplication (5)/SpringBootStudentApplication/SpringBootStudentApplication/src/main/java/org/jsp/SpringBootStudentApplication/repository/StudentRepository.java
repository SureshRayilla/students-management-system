package org.jsp.SpringBootStudentApplication.repository;


import org.jsp.SpringBootStudentApplication.dto.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	//Student findById(int sid);
	@Query("select s from Student s where s.email=?1")
	public Student login(String mail);

}
