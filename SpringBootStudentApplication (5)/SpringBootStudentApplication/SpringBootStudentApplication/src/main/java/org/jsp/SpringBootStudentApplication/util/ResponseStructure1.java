package org.jsp.SpringBootStudentApplication.util;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResponseStructure1<T>{
	private String msg;
	private int statusCode;
	private T data;
	private LocalDateTime dataTime=LocalDateTime.now();

}
