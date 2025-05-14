package org.jsp.SpringBootStudentApplication.exception;

public class IdNotFoundException extends RuntimeException {
	String msg;

	public IdNotFoundException(String msg) {
		//super();
		this.msg=msg;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return msg;
	}

	
	
	

}