package com.app.service;

import java.util.List;

import com.app.dto.faculty.FacAddDto;
import com.app.entities.primary.Faculty;

public interface FacultyService {
	List<Faculty> getFacultyList();
	Faculty addFaculty(Long orgId,FacAddDto facDto);
}
