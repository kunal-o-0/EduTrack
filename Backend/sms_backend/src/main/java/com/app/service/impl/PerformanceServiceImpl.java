package com.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PerformanceDao;
import com.app.dao.StudentDao;
import com.app.dao.SubjectDao;
import com.app.dto.performance.PerforDto;
import com.app.entities.secondary.Performance;
import com.app.service.PerformanceService;

@Service
@Transactional
public class PerformanceServiceImpl implements PerformanceService{
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private PerformanceDao perforDao;
	@Autowired
	private StudentDao studDao;
	@Autowired
	private SubjectDao subDao;
	
	@Override
	public List<Performance> getPerforList() {
		return perforDao.findAll();
	}
	
	@Override
	public Performance addPerfor(Long studId,Long subId, PerforDto perforDto) {
		Performance perforEnt=mapper.map(perforDto, Performance.class);
		perforEnt.setStudent(studDao.findById(studId).orElseThrow());
		perforEnt.setSubject(subDao.findById(subId).orElseThrow());
		return perforDao.save(perforEnt);
	}
}
