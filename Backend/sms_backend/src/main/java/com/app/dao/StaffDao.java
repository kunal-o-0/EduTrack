package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.primary.Staff;

public interface StaffDao extends JpaRepository<Staff, Long> {}
