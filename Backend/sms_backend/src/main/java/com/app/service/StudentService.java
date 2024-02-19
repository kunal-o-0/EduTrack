package com.app.service;

import java.util.List;

import com.app.dto.attendance.AttendDto;
import com.app.dto.student.StudAfterLoginDto;
import com.app.dto.student.StudAttendDto;
import com.app.dto.student.StudDto;
import com.app.dto.student.StudGetPendingFeesDto;
import com.app.dto.student.StudGetTransDto;
import com.app.dto.student.StudLoginDto;
import com.app.dto.student.StudPerfDto;
import com.app.entities.primary.Student;

public interface StudentService {
	List<StudDto> getStudentList();
	Student addStudent(Long orgId,Long courseId,StudDto studDto);
	Student updateStud(Long studId,StudDto studDto);
	void deleteStud(Long studId);
	
	List<StudAttendDto> getAttendance(Long studId);
	List<StudPerfDto> getPerformance(Long studId);
	List<StudGetTransDto> getTransactions(Long studId);
	List<StudGetPendingFeesDto> getPendingFees(Long studId);
	StudAfterLoginDto authenticateStud(StudLoginDto studDto);
}
