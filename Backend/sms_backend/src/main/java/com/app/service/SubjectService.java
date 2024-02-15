package com.app.service;

import java.util.List;

import com.app.dto.subject.SubDto;
import com.app.entities.secondary.Subject;

public interface SubjectService {
	List<SubDto> getSubList();
	Subject addSub(Long courseId,SubDto subDto);
	Subject updateSub(Long subId,SubDto subDto);
	void deleteSub(Long subId);
}
