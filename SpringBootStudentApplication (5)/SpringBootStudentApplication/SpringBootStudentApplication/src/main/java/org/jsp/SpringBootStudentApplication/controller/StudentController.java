package org.jsp.SpringBootStudentApplication.controller;

import java.io.IOException;

import java.util.List;

import org.jsp.SpringBootStudentApplication.dto.Student;
import org.jsp.SpringBootStudentApplication.service.StudentService;
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
import org.springframework.web.multipart.MultipartFile;
import org.jsp.SpringBootStudentApplication.dto.Course;

@RestController
@CrossOrigin
public class StudentController {
	@Autowired
	private StudentService studentService;
//	@PostMapping("/savestudent")
//	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody List<Student> student){
//		return studentService.saveStudent(student);
//		
//	}
//	
//	@PostMapping("/findstudent/{sid}")
//	public ResponseEntity<ResponseStructure1<Student>> findStudentById(@PathVariable int sid){
//		return studentService.findStudentById(sid);
//		
//	}
	
	@PostMapping("/savestudent")
	public ResponseEntity<ResponseStructure1<Student>> saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	@GetMapping("/findstudent/{sid}")
	public ResponseEntity<ResponseStructure1<Student>> findStudentByid(@PathVariable int sid) {
		return studentService.findStudentById(sid);
	}
	@PostMapping("/loginstudent")
	public ResponseEntity<ResponseStructure1<Student>> login(@RequestBody Student student) {
		return studentService.login(student);
	}
	@CrossOrigin
	@PutMapping("/updatestudent")
	public ResponseEntity<ResponseStructure1<Student>> updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
    @CrossOrigin
	@PutMapping("/uploadimage/{sid}")
	public ResponseEntity<ResponseStructure1<Student>> uploadImage(@PathVariable int sid, @RequestBody MultipartFile file) throws IOException {
		return studentService.uploadImage(sid, file);
	}
	@DeleteMapping("/deletestudent/{sid}")
	public ResponseEntity<ResponseStructure1<Student>> deleteStudent(@PathVariable int sid) {
		return studentService.deleteStudent(sid);
	}
	 @CrossOrigin
	@GetMapping("/fetchimg/{sid}")
	public ResponseEntity<byte[]> fethImg(@PathVariable int sid) {
		return studentService.fetchImage(sid);
	}
	@PutMapping("/addcourse/{sid}/{cid}")
	public ResponseEntity<ResponseStructure1<Student>> addCourseToStudent(@PathVariable int sid,@PathVariable int cid) {
		return studentService.addCourseToStudent(sid, cid);
	}
	@GetMapping("/fetchcourses/{sid}")
	public ResponseEntity<ResponseStructure1<List<Course>>> fetchCoursesFromStudent(@PathVariable int sid) {
		return studentService.fetchCoursesFromStudent(sid);
	}
	@DeleteMapping("/deletcourse/{sid}/{cid}")
	public ResponseEntity<ResponseStructure1<Student>> deleteCourseFromStudent(@PathVariable int sid,@PathVariable int cid){
		return studentService.deleteCourseFromStudent(sid, cid);
		
		
	}
	

}
