package org.jsp.SpringBootStudentApplication.service;

import java.io.IOException;
import java.util.Optional;

import org.jsp.SpringBootStudentApplication.dao.AdminDao;
import org.jsp.SpringBootStudentApplication.dto.Admin;
import org.jsp.SpringBootStudentApplication.dto.Student;
import org.jsp.SpringBootStudentApplication.exception.IdNotFoundException;
import org.jsp.SpringBootStudentApplication.exception.MailInvalidException;
import org.jsp.SpringBootStudentApplication.exception.PasswordInvalidException;
import org.jsp.SpringBootStudentApplication.util.ResponseStructure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	
	ResponseStructure1<Admin> structure=new ResponseStructure1<>();
	
	public ResponseEntity<ResponseStructure1<Admin>> saveAdmin(Admin admin){
		structure.setData(adminDao.saveAdmin(admin));
		structure.setMsg("Registered successfully...");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure1<Admin>> (structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure1<Admin>> findAdminById(int id){
		Admin admindb=adminDao.findAdminById(id);
		if(admindb!=null) {
		structure.setData(admindb);
		structure.setMsg("Id fetched successfully....");
		structure.setStatusCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure1<Admin>> (structure,HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException("Id not found...");
		}
	}
	public ResponseEntity<ResponseStructure1<Admin>> login(Admin admin){
		Admin admindb=adminDao.login(admin.getEmail());
		if(admindb!=null) {
			if(admindb.getPassword().equals(admin.getPassword())) {
			structure.setData(admindb);
			structure.setMsg("Login successfull...!!!");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure1<Admin>> (structure,HttpStatus.ACCEPTED);
			}else {
				throw new PasswordInvalidException("Password mismatched....");
			}
			}else {
				throw new MailInvalidException("Mail is wrong.please enter correct mail!!!");
		}
		
	}
	public ResponseEntity<ResponseStructure1<Admin>> updateAdmin(Admin admin){
		Admin admindb=adminDao.findAdminById(admin.getAid());
		if(admindb!=null) {
			structure.setData(adminDao.updateAdmin(admin));
			structure.setMsg("Updated successfully...");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure1<Admin>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Id not found...");
		}
	}
	public ResponseEntity<ResponseStructure1<Admin>> uploadImage(int id,MultipartFile file) throws IOException {
		Admin admindb=adminDao.findAdminById(id);
		if(admindb != null) {
			admindb.setAid(id);
			admindb.setImg(file.getBytes());
			structure.setData(adminDao.updateAdmin(admindb));
			structure.setMsg("Image Uploaded");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure1<Admin>>(structure,HttpStatus.ACCEPTED);
		}else {
			throw new IdNotFoundException("Admin Id Not found");
		}
	}
	public ResponseEntity<byte[]> fetchImage(int id) {
		Admin admindb=adminDao.findAdminById(id);
		if(admindb != null) {
			byte[] img=admindb.getImg();
			HttpHeaders headers = new HttpHeaders();
		//	headers.setContentType(MediaType.IMAGE_PNG);
			headers.setContentType(MediaType.IMAGE_JPEG);
			return new ResponseEntity<byte[]>(img,headers,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Admin Id Not found");
		}
		
	}
	public ResponseEntity<ResponseStructure1<Admin>> deleteAdminById(int id){
		Admin admindb=adminDao.findAdminById(id);
		if(admindb!=null) {
			adminDao.deleteAdmin(id);
			structure.setMsg("deleted successfully....");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure1<Admin>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException("Id not found...");
	}

}
