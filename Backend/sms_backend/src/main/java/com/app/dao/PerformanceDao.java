package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.secondary.Performance;

public interface PerformanceDao extends JpaRepository<Performance, Long>{}
