package org.jsp.SpringBootStudentApplication.util;

import java.time.LocalDateTime;
import java.util.Optional;

import lombok.Data;

@Data
public class RS2<T> {
	private String msg;
	private int statusCode;
	private Optional<T> data;
	private LocalDateTime dataTime=LocalDateTime.now();

}
