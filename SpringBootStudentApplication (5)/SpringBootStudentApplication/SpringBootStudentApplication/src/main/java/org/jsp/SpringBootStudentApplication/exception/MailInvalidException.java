package org.jsp.SpringBootStudentApplication.exception;

public class MailInvalidException extends RuntimeException{
	private String msg;

	public MailInvalidException(String msg) {
//		super(msg);
		this.msg=msg;
		
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
//		return super.getMessage();
		return msg;
	}

}