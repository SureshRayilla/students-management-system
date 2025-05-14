package org.jsp.SpringBootStudentApplication.dao;

import java.util.Optional;

import org.jsp.SpringBootStudentApplication.dto.Admin;
import org.jsp.SpringBootStudentApplication.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
	@Autowired
	private AdminRepository adminRepository;
	
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	public Admin findAdminById(int id) {
		Optional<Admin> admindb=adminRepository.findById(id);
		if(admindb!=null) {
			return admindb.get();
		}else {
			return null;
		}
		
	}
	public Admin login(String email) {
		return adminRepository.login(email);
	}
	public Admin updateAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	public void deleteAdmin(int id) {
		Optional<Admin> admindb=adminRepository.findById(id);
		if(admindb!=null) {
			adminRepository.deleteById(id);
		}else {
			return;
		}
	}
	
	

}
