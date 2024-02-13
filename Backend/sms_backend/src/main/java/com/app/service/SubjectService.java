package com.app.service;

import java.util.List;

import com.app.dto.subject.SubAddDto;
import com.app.entities.secondary.Subject;

public interface SubjectService {
	List<Subject> getSubList();
	Subject addSub(Long courseId,SubAddDto subDto);
}
