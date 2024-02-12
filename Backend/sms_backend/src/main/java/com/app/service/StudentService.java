package com.app.service;

import java.util.List;

import com.app.dto.student.StudAddDto;
import com.app.entities.primary.Student;

public interface StudentService {
	List<Student> getStudentList();
	Student addStudent(Long orgId,Long courseId,StudAddDto studDto);
}
