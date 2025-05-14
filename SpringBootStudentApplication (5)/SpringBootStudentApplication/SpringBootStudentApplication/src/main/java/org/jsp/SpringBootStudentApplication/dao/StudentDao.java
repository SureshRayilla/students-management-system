package org.jsp.SpringBootStudentApplication.dao;

import java.util.List;

import java.util.Optional;

import org.jsp.SpringBootStudentApplication.dto.Course;
import org.jsp.SpringBootStudentApplication.dto.Student;
import org.jsp.SpringBootStudentApplication.repository.CourseRepository;
import org.jsp.SpringBootStudentApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;
	
//	public List<Student> saveStudent(List<Student> student){
//		return studentRepository.saveAll(student);
//	}
//
//	public Student findStudentById(int sid){
//		return studentRepository.findById(sid);
//	}
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student findStudentById(int id) {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent()) {
			return student.get();
		}else
			return null;
	}
	public Student login(String mail) {
		return studentRepository.login(mail);
	}
	public Student updateStudent(Student student) {
			return studentRepository.save(student);
	}
	public Student addCourseToStudent(int sid,int cid) {
		Optional<Student> student = studentRepository.findById(sid);
		Optional<Course> course = courseRepository.findById(cid);
		if(student.isPresent() && course.isPresent()) {
			Student student1 = student.get();
			Course course1 = course.get();
			List<Course>listCourses = student1.getCourse();
			listCourses.add(course1);
			student1.setCourse(listCourses);
			studentRepository.save(student1);
			return student1;
		}else {
			return null;
		}
	
	
	}
	public void deleteStudent(int sid) {
		 studentRepository.deleteById(sid);
	}


}
