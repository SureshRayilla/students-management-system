package org.jsp.SpringBootStudentApplication.controller;

import java.util.List;
import org.jsp.SpringBootStudentApplication.dto.Course;
import org.jsp.SpringBootStudentApplication.dto.Student;
import org.jsp.SpringBootStudentApplication.service.CourseService;
import org.jsp.SpringBootStudentApplication.util.ResponseStructure;
import org.jsp.SpringBootStudentApplication.util.ResponseStructure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CourseController {
	@Autowired
	private CourseService courseService;
//	@PostMapping("/savecourse")
//	public ResponseEntity<ResponseStructure<Course>> saveStudent(@RequestBody List<Course> course){
//		return courseService.saveCourse(course);
//		
//	}
	@PostMapping("/savecourse")
	public ResponseEntity<ResponseStructure1<Course>> saveStudent(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}
	//fetch course by id
	@GetMapping("fetchcourse/{cid}")
	public ResponseEntity<ResponseStructure1<Course>> fetchCourse(@PathVariable int cid) {
		return courseService.fetchCourse(cid);
	
	}
	
	@GetMapping("/fetchallCourses")
	public ResponseEntity<ResponseStructure1<List<Course>>> fetchAllCourse(){
		return courseService.fetchAllCourses();
	}
	@PutMapping("/updateCourse")
	public ResponseEntity<ResponseStructure1<Course>> updateCourse(@RequestBody Course course){
		return courseService.updateCourse(course);
	}
	
	//delete course
	@DeleteMapping("/deletecourse/{cid}")
	public ResponseEntity<ResponseStructure1<Course>> deleteCourse(@PathVariable int cid) {
		return courseService.deleteCourse(cid);
	}
	@GetMapping("/getStudent/{cid}")
	public ResponseEntity<ResponseStructure1<List<Student>>> getStudentByCourse(@PathVariable int cid){
		return courseService.getStudentByCourse(cid);
		
	}

}


