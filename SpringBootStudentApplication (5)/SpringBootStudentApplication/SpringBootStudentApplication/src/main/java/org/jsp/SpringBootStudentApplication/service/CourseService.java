package org.jsp.SpringBootStudentApplication.service;

import java.util.List;
import java.util.Optional;

import org.jsp.SpringBootStudentApplication.dao.CourseDao;
import org.jsp.SpringBootStudentApplication.dto.Course;
import org.jsp.SpringBootStudentApplication.dto.Student;
import org.jsp.SpringBootStudentApplication.exception.IdNotFoundException;
import org.jsp.SpringBootStudentApplication.util.ResponseStructure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class CourseService {
	@Autowired
	private CourseDao courseDao;
	
ResponseStructure1<Course> structure=new ResponseStructure1<>();
//RS2<Course> struct=new RS2<>();
 //ResponseStructure1<Course> structure1=new ResponseStructure1<>();
//	
//	public ResponseEntity<ResponseStructure<Course>> saveCourse(List<Course> course){
//		structure.setData(courseDao.saveCourse(course));
//		structure.setMsg("Student Data saved...");
//		structure.setStatusCode(HttpStatus.CREATED.value());
//		return new ResponseEntity<ResponseStructure<Course>> (structure,HttpStatus.CREATED);
//		
//	}
//	public ResponseEntity<ResponseStructure1<Course>> findCourseById(int cid){
//		Course coursedb=courseDao.findCourseById(cid);
//		if(coursedb!=null) {
//			structure1.setData(coursedb);
//			structure1.setMsg("student id found...");
//			structure1.setStatusCode(HttpStatus.FOUND.value());
//			return new ResponseEntity<ResponseStructure1<Course>>(structure1,HttpStatus.FOUND);
//		}else {
//			throw new IdNotFoundException("Course Id not present...");
//		}
//		
//	}
//private ResponseStructure<Course> structure = new ResponseStructure();
	
//	public ResponseEntity<ResponseStructure<Course>> saveCourse(List<Course> course) {
//			List<Course> list=courseDao.saveCourse(course);
//			structure.setData(list);
//			structure.setMsg("course saved");
//			structure.setStatusCode(HttpStatus.CREATED.value());
//			return new ResponseEntity<ResponseStructure<Course>>(structure,HttpStatus.CREATED);
//	}

//save course
public ResponseEntity<ResponseStructure1<Course>> saveCourse(Course course) {
	structure.setData(courseDao.saveCourse(course));
	structure.setMsg("Course saved successfully");
	structure.setStatusCode(HttpStatus.CREATED.value());
	return new ResponseEntity<ResponseStructure1<Course>> (structure,HttpStatus.CREATED);
}
public ResponseEntity<ResponseStructure1<Course>> fetchCourse(int cid) {
	Course course=courseDao.fetchCourse(cid);
	if(course!=null) {
		structure.setData(course);
        structure.setMsg("Course  found");
        structure.setStatusCode(HttpStatus.FOUND.value());
        return new ResponseEntity<ResponseStructure1<Course>>(structure,HttpStatus.FOUND);
}else {
	return null;
}

}

public ResponseEntity<ResponseStructure1<List<Course>>> fetchAllCourses() {
    List<Course> courses = courseDao.fetchAllCourses();
    ResponseStructure1<List<Course>> structure = new ResponseStructure1<>();
    structure.setData(courses);
    structure.setMsg("All courses retrieved");
    structure.setStatusCode(HttpStatus.OK.value());
    return new ResponseEntity<>(structure, HttpStatus.OK);
}


public ResponseEntity<ResponseStructure1<Course>> updateCourse(Course course){
     Course coursedb=courseDao.fetchCourse(course.getCid());
     if(coursedb!=null) {
    	 structure.setData(courseDao.updateCourse(course));
    	 structure.setMsg("Data updated successfully....");
    	 structure.setStatusCode(HttpStatus.OK.value());
    	 return new ResponseEntity<ResponseStructure1<Course>> (structure,HttpStatus.OK);
     }else {
    	 throw new IdNotFoundException("Id not found to update data...");
     }
}

public ResponseEntity<ResponseStructure1<Course>> deleteCourse(int cid) {
	Course course=courseDao.fetchCourse(cid);
	if(course!=null) {
        structure.setData(courseDao.deleteCourse(cid));
        structure.setMsg("Course  deleted");
        structure.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<ResponseStructure1<Course>>(structure,HttpStatus.OK);
	}else {
		 throw new IdNotFoundException("Id not found...");
	}
}
public ResponseEntity<ResponseStructure1<List<Student>>> getStudentByCourse(int cid){
	List<Student> students=courseDao.getStudentsByCourse(cid);
	if(students!=null) {
		ResponseStructure1<List<Student>> structure = new ResponseStructure1<>();
		structure.setData(students);
		structure.setMsg("Students fetched successfully...");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure1<List<Student>>> (structure,HttpStatus.OK);
	}else {
		throw new IdNotFoundException("Id not found...");
	}
}
}


