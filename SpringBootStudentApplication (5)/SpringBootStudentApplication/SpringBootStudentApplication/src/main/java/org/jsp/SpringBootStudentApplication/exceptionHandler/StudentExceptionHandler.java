package org.jsp.SpringBootStudentApplication.exceptionHandler;


import org.jsp.SpringBootStudentApplication.exception.IdNotFoundException;
import org.jsp.SpringBootStudentApplication.exception.MailInvalidException;
import org.jsp.SpringBootStudentApplication.exception.PasswordInvalidException;
import org.jsp.SpringBootStudentApplication.util.RS2;
import org.jsp.SpringBootStudentApplication.util.ResponseStructure1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class StudentExceptionHandler {
ResponseStructure1<String> structure=new ResponseStructure1<String>();
RS2<String> struct=new RS2<>();
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure1<String>> IdNotFound(IdNotFoundException idNotFoundException){
		structure.setData(idNotFoundException.getMessage());
		structure.setMsg("Id is not present.");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure1<String>>(structure, HttpStatus.NOT_FOUND);
	

}
	@ExceptionHandler(MailInvalidException.class)
	public ResponseEntity<ResponseStructure1<String>> mailIdNotFound(MailInvalidException mailInvalidException) {
		structure.setData(mailInvalidException.getMessage());
		structure.setMsg("login failed");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure1<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(PasswordInvalidException.class)
	public ResponseEntity<ResponseStructure1<String>> passowrdInvalid(PasswordInvalidException passwordInvalidException) {
		structure.setData(passwordInvalidException.getMessage());
		structure.setMsg("login failed");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure1<String>>(structure,HttpStatus.NOT_FOUND);
	}

	
}
