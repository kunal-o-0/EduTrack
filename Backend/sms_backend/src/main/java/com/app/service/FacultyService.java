package com.app.service;

import java.util.List;

import com.app.dto.faculty.FacDto;
import com.app.entities.primary.Faculty;

public interface FacultyService {
	List<FacDto> getFacultyList();
	Faculty addFaculty(Long orgId,FacDto facDto);
}
