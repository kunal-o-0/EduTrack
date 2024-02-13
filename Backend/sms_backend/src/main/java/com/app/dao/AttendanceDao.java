package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.secondary.Attendance;

public interface AttendanceDao extends JpaRepository<Attendance,Long>{}
