package com.app.service;

import java.util.List;

import com.app.dto.attendance.AttendAddDto;
import com.app.entities.secondary.Attendance;

public interface AttendanceService {
	List<Attendance> getAttendList();
	Attendance addAttend(Long studId,Long schedId,AttendAddDto attendDto);
}
