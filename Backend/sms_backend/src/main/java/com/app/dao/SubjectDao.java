package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.secondary.Subject;

public interface SubjectDao extends JpaRepository<Subject, Long>{}
