package com.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AttendanceDao;
import com.app.dao.ScheduleDao;
import com.app.dao.StudentDao;
import com.app.dto.attendance.AttendDto;
import com.app.entities.secondary.Attendance;
import com.app.service.AttendanceService;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService{
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private AttendanceDao attendDao;
	@Autowired
	private StudentDao studDao;
	@Autowired
	private ScheduleDao schedDao;
	
	@Override
	public List<Attendance> getAttendList() {
		return attendDao.findAll();
	}
	@Override
	public Attendance addAttend(Long studId, Long schedId, AttendDto attendDto) {
		Attendance attendEnt=mapper.map(attendDto, Attendance.class);
		attendEnt.setStudent(studDao.findById(studId).orElseThrow());
		attendEnt.setSchedule(schedDao.findById(schedId).orElseThrow());
		return attendDao.save(attendEnt);
	}
}
