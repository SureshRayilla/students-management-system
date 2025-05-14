package org.jsp.SpringBootStudentApplication.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	private String fname;
	public String lname;
	private String email;
	private String password;
	private long mobileNumber;
	private String address;
	@Lob  //to consider as large object
	@Column(columnDefinition = "longblob",length = 999999999)//size
	private byte img[];

}
