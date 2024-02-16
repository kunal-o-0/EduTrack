package com.app.service;

import java.util.List;

import com.app.dto.attendance.AttendDto;
import com.app.dto.student.StudAttendDto;
import com.app.dto.student.StudDto;
import com.app.entities.primary.Student;

public interface StudentService {
	List<StudDto> getStudentList();
	Student addStudent(Long orgId,Long courseId,StudDto studDto);
	Student updateStud(Long studId,StudDto studDto);
	void deleteStud(Long studId);
	
	List<StudAttendDto> getAttendance(Long studId);
}
