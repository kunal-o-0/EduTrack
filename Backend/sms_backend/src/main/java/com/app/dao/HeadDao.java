package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.primary.Head;

public interface HeadDao extends JpaRepository<Head, Long>{}
