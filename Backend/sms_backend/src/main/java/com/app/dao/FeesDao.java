package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.secondary.Fees;

public interface FeesDao extends JpaRepository<Fees, Long>{}
