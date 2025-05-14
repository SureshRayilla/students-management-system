package org.jsp.SpringBootStudentApplication.service;

import java.io.IOException;


import java.util.List;

import org.jsp.SpringBootStudentApplication.dao.StudentDao;
import org.jsp.SpringBootStudentApplication.dto.Student;
import org.jsp.SpringBootStudentApplication.exception.IdNotFoundException;
import org.jsp.SpringBootStudentApplication.exception.MailInvalidException;
import org.jsp.SpringBootStudentApplication.exception.PasswordInvalidException;
import org.jsp.SpringBootStudentApplication.util.RS2;
import org.jsp.SpringBootStudentApplication.util.ResponseStructure;
import org.jsp.SpringBootStudentApplication.util.ResponseStructure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.jsp.SpringBootStudentApplication.dto.Course;
@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	
	ResponseStructure<Student> structure=new ResponseStructure<>();
	RS2<Student> struct=new RS2<>();
	ResponseStructure1<Student> structure1=new ResponseStructure1<>();
	
	public ResponseEntity<ResponseStructure1<Student>> saveStudent(Student student){
		structure1.setData(studentDao.saveStudent(student));
		structure1.setMsg("Student Data saved...");
		structure1.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure1<Student>> (structure1,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure1<Student>> findStudentById(int sid){
		Student studentdb=studentDao.findStudentById(sid);
		if(studentdb!=null) {
			structure1.setData(studentdb);
			structure1.setMsg("student id found...");
			structure1.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure1<Student>>(structure1,HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException("Student Id not present.........");
		
	}

}
	public ResponseEntity<ResponseStructure1<Student>> login(Student student) {
		Student studentdb=studentDao.login(student.getEmail());
		if(studentdb!=null) {
			if(studentdb.getPassword().equals(student.getPassword())) {
				ResponseStructure1<Student> structure=new ResponseStructure1<Student>();
				structure.setData(studentDao.saveStudent(studentdb));
				structure.setMsg("data saved successfully");
				structure.setStatusCode(HttpStatus.CREATED.value());
				return new ResponseEntity<ResponseStructure1<Student>>(structure,HttpStatus.CREATED);
			}else {
				throw new PasswordInvalidException("password not match");// we can give custom exception as
				// PasswordNotMatchExceptioon
			}
		}else {
			throw new MailInvalidException("invalid  mail ");// we can give custom exception as EmailNotFoundExceptioon
		}
	}
	public ResponseEntity<ResponseStructure1<Student>> updateStudent(Student student){
		Student studentdb=studentDao.findStudentById(student.getSid());
		if(studentdb!=null) {
			structure1.setData(studentDao.updateStudent(student));
			structure1.setMsg("details updated successfully....");
			structure1.setStatusCode(HttpStatus.OK.value());
		    return new ResponseEntity<ResponseStructure1<Student>>(structure1,HttpStatus.OK);
		}else {
		    	throw new IdNotFoundException("Id not found...");
		    }
		}
	public ResponseEntity<ResponseStructure1<Student>> uploadImage(int id,MultipartFile file) throws IOException {
		Student studentdb=studentDao.findStudentById(id);
		if(studentdb != null) {
			studentdb.setSid(id);
			studentdb.setImg(file.getBytes());
			structure1.setData(studentDao.updateStudent(studentdb));
			structure1.setMsg("Image Uploaded");
			structure1.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure1<Student>>(structure1,HttpStatus.ACCEPTED);
		}else {
			throw new IdNotFoundException("Student Id Not found");
		}
	}
	public ResponseEntity<byte[]> fetchImage(int id) {
		Student studentdb=studentDao.findStudentById(id);
		if(studentdb != null) {
			byte[] img=studentdb.getImg();
			HttpHeaders headers = new HttpHeaders();
		//	headers.setContentType(MediaType.IMAGE_PNG);
			headers.setContentType(MediaType.IMAGE_JPEG);
			return new ResponseEntity<byte[]>(img,headers,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Student Id Not found");
		}
		
	}
	
	public ResponseEntity<ResponseStructure1<Student>> addCourseToStudent(int sid,int cid) {
		Student studentDb=studentDao.addCourseToStudent(sid, cid);
		if(studentDb != null) {
			structure1.setData(studentDb);
			structure1.setMsg("Course Added");
			structure1.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure1<Student>>(structure1,HttpStatus.ACCEPTED);
		}else {
			throw new IdNotFoundException("Student Id Not found");
		}
	}
	
	
	public ResponseEntity<ResponseStructure1<List<Course>>> fetchCoursesFromStudent(int id){
		Student studentdb=studentDao.findStudentById(id);
		if(studentdb!=null) {
			ResponseStructure1<List<Course>> structure=new ResponseStructure1<>();
			List<Course> courses=studentdb.getCourse();
			structure.setData(courses);
			structure.setMsg("courses found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure1<List<Course>>>(structure,HttpStatus.FOUND);		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure1<Student>> deleteCourseFromStudent(int sid,int cid){
		Student studentdb=studentDao.findStudentById(sid);
		if(studentdb!=null) {
			List<Course> listCourses=studentdb.getCourse();
			for (Course course : listCourses) {
				if(course.getCid()==cid) {
					listCourses.remove(course);
					studentdb.setCourse(listCourses);
					
					structure1.setData(studentDao.saveStudent(studentdb));
					structure1.setMsg("course removed");
					structure1.setStatusCode(HttpStatus.OK.value());
					return new ResponseEntity<ResponseStructure1<Student>>(structure1,HttpStatus.OK);
					
				}
			}
		}
		 throw new IdNotFoundException("not found");
	}
	public ResponseEntity<ResponseStructure1<Student>> deleteStudent(int sid){
		Student studentdb=studentDao.findStudentById(sid);
		if(studentdb!=null) {
		   studentDao.deleteStudent(sid);
		   structure1.setMsg("Deleted Successfully...");
		   structure1.setStatusCode(HttpStatus.OK.value());
		   return new ResponseEntity<ResponseStructure1<Student>> (structure1,HttpStatus.OK);
			}else {
				throw new IdNotFoundException("Id not found...");
			}
		}
	
}
