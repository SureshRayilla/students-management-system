package org.jsp.SpringBootStudentApplication.controller;

import java.io.IOException;

import org.jsp.SpringBootStudentApplication.dto.Admin;
import org.jsp.SpringBootStudentApplication.dto.Student;
import org.jsp.SpringBootStudentApplication.service.AdminService;
import org.jsp.SpringBootStudentApplication.util.ResponseStructure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/saveAdmin")
	public ResponseEntity<ResponseStructure1<Admin>> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	@GetMapping("/findAdmin/{aid}")
	public ResponseEntity<ResponseStructure1<Admin>> findById(@PathVariable int aid){
		return adminService.findAdminById(aid);
	}
	@PostMapping("/loginAdmin")
	public ResponseEntity<ResponseStructure1<Admin>> login(@RequestBody Admin admin){
		return adminService.login(admin);
	}
	@PutMapping("/updateAdmin")
	public ResponseEntity<ResponseStructure1<Admin>> updateAdmin(@RequestBody Admin admin){
		return adminService.updateAdmin(admin);
	}
	@PutMapping("/uploadadminimage/{aid}")
	public ResponseEntity<ResponseStructure1<Admin>> uploadImage(@PathVariable int aid, @RequestBody MultipartFile file) throws IOException {
		return adminService.uploadImage(aid, file);
	}
	@GetMapping("/fetchadminimg/{aid}")
	public ResponseEntity<byte[]> fetchImg(@PathVariable int aid) {
		return adminService.fetchImage(aid);
	}
	@DeleteMapping("deleteAdmin/{aid}")
	public ResponseEntity<ResponseStructure1<Admin>> deleteAdminById(@PathVariable int aid){
		return adminService.deleteAdminById(aid);
	}

}
