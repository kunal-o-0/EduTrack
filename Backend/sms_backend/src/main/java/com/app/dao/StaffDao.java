package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.primary.Staff;

public interface StaffDao extends JpaRepository<Staff, Long> {
	@Query("select s from Staff s where s.email=:email and s.password=:password")
	Optional<Staff> findByEmailPassword(@Param("email") String email,@Param("password") String password);
}
