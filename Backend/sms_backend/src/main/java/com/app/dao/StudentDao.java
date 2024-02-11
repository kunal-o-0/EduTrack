package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.primary.Student;

public interface StudentDao extends JpaRepository<Student, Long>{}
