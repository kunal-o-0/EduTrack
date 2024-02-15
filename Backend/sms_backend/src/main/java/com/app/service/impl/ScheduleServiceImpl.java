package com.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ScheduleDao;
import com.app.dao.SubjectDao;
import com.app.dto.schedule.SchedDto;
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
	public List<SchedDto> getSchedList() {
		return schedDao.findAll()
						.stream()
						.map((schedEnt)->
											{
												SchedDto schedDto=mapper.map(schedEnt, SchedDto.class);
												schedDto.setSubId(schedEnt.getSubject().getSubId());
												return schedDto;
											})
						.collect(Collectors.toList());
	}
	
	@Override
	public Schedule addSched(Long subId, SchedDto schedDto) {
		Schedule schedEnt=mapper.map(schedDto, Schedule.class);
		schedEnt.setSubject(subDao.findById(subId).orElseThrow());
		return schedDao.save(schedEnt);
	}
	
	@Override
	public Schedule updateSched(Long schedId, SchedDto schedDto) {
		Schedule schedOld=schedDao.findById(schedId).orElseThrow();
		Schedule schedNew=mapper.map(schedDto, Schedule.class);
		schedNew.setSchedId(schedOld.getSchedId());
		schedNew.setSubject(schedOld.getSubject());
		return schedDao.save(schedNew);
	}
	
	@Override
	public void deleteSched(Long schedId) {
		schedDao.deleteById(schedId);
		schedDao.flush();
	}
}
