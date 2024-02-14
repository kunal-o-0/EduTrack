package com.app.service;

import java.util.List;

import com.app.dto.attendance.AttendDto;
import com.app.entities.secondary.Attendance;

public interface AttendanceService {
	List<AttendDto> getAttendList();
	Attendance addAttend(Long studId,Long schedId,AttendDto attendDto);
}
