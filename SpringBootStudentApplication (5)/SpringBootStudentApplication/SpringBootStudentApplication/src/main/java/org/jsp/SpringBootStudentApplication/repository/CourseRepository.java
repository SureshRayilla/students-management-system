package org.jsp.SpringBootStudentApplication.repository;

import org.jsp.SpringBootStudentApplication.dto.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	//Course findById(int cid);
}
