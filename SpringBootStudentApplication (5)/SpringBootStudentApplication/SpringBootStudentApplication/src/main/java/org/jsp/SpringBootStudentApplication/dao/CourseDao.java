package org.jsp.SpringBootStudentApplication.dao;
//import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.jsp.SpringBootStudentApplication.dto.Course;
import org.jsp.SpringBootStudentApplication.dto.Student;
import org.jsp.SpringBootStudentApplication.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CourseDao {
	@Autowired
	private CourseRepository courseRepository;
	
//	public List<Course> saveCourse(List<Course> course) {
//		List<Course> courses = new ArrayList<>(); 
//		for (Course course2 : course) {
//			courses.add(courseRepository.save(course2));
//		}
//		return courses;
//		
//	}
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}
	//fetch course
	public Course fetchCourse(int id) {
		Optional<Course> course = courseRepository.findById(id);
		if(course.isPresent()) {
			Course course2 = course.get();
			return course2;
		}
		return null;
	}
	// Fetch all courses
	public List<Course> fetchAllCourses() {
	    return courseRepository.findAll();
	}
	
	public Course updateCourse(Course course) {
		return courseRepository.save(course);
	}

	
	//delete course
	public Course deleteCourse(int cid) {
		Optional<Course> course = courseRepository.findById(cid);
		if(course.isPresent()) {
			Course course2 = course.get();
			courseRepository.delete(course2);
			return course2;
		}
		
		return null;
	}
	public List<Student> getStudentsByCourse(int cid){
		Optional<Course> coursedb=courseRepository.findById(cid);
		if(coursedb.isPresent()) {
		     return coursedb.get().getStudent();
		}else {
			return null;
		}
	}

}
	
	
	
//	public List<Course> saveCourse(List<Course> course) {
//		return courseRepository.saveAll(course);
//	}
//    public Course findCourseById(int cid){
//    	return courseRepository.findById(cid);
//    }


