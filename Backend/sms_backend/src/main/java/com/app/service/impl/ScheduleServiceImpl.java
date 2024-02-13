package com.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ScheduleDao;
import com.app.dao.SubjectDao;
import com.app.dto.schedule.SchedAddDto;
import com.app.entities.secondary.Schedule;
import com.app.service.ScheduleService;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService{
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private ScheduleDao schedDao;
	@Autowired
	private SubjectDao subDao;
	
	@Override
	public List<Schedule> getSchedList() {
		return schedDao.findAll();
	}
	@Override
	public Schedule addSched(Long subId, SchedAddDto schedDto) {
		Schedule schedEnt=mapper.map(schedDto, Schedule.class);
		schedEnt.setSubject(subDao.findById(subId).orElseThrow());
		return schedDao.save(schedEnt);
	}
}
