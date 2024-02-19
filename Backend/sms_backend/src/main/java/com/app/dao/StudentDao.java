package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.primary.Student;

public interface StudentDao extends JpaRepository<Student, Long>
{
	@Query("select s from Student s where s.email=:email and s.password=:password")
	Optional<Student> findByEmailPassword(@Param("email") String email,@Param("password") String password);
}
