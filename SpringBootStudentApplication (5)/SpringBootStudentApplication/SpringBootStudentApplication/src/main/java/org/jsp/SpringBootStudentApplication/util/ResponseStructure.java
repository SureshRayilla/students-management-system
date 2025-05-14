package org.jsp.SpringBootStudentApplication.util;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private String msg;
	private int statusCode;
	private List<T> data;
	private LocalDateTime dataTime=LocalDateTime.now();

}
