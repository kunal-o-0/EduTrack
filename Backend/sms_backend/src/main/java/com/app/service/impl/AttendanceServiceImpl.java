package com.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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
	public List<AttendDto> getAttendList() {
		return attendDao.findAll()
						.stream()
						.map((attendEnt)->
											{
												AttendDto attendDto=mapper.map(attendEnt, AttendDto.class);
												attendDto.setStudId(attendEnt.getStudent().getStudId());
												attendDto.setSchedId(attendEnt.getSchedule().getSchedId());
												return attendDto;
											})
						.collect(Collectors.toList());
	}
	
	@Override
	public Attendance addAttend(Long studId, Long schedId, AttendDto attendDto) {
		Attendance attendEnt=mapper.map(attendDto, Attendance.class);
		attendEnt.setStudent(studDao.findById(studId).orElseThrow());
		attendEnt.setSchedule(schedDao.findById(schedId).orElseThrow());
		return attendDao.save(attendEnt);
	}
	
	@Override
	public Attendance updateAttend(Long attendId, AttendDto attendDto) {
		Attendance attendNew=mapper.map(attendDto, Attendance.class);
		Attendance attendOld=attendDao.findById(attendId).orElseThrow();
		attendNew.setAttendId(attendOld.getAttendId());
		attendNew.setStudent(attendOld.getStudent());
		attendNew.setSchedule(attendOld.getSchedule());
		return attendDao.save(attendNew);
	}
	
	@Override
	public void deleteAttend(Long attendId) {
		
	}
}
