package org.jsp.SpringBootStudentApplication.repository;

import org.jsp.SpringBootStudentApplication.dto.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	@Query("select a from Admin a where a.email=?1")
	public Admin login(String mail);

}
