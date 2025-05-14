package org.jsp.SpringBootStudentApplication.exception;

public class PasswordInvalidException extends RuntimeException{
	private String msg;

	public PasswordInvalidException(String msg) {
		this.msg=msg;
		
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return msg;
//		return super.getMessage();
	}

}