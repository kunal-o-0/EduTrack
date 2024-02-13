package com.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.FeesDao;
import com.app.dao.StudentDao;
import com.app.dto.fees.FeesDto;
import com.app.entities.secondary.Fees;
import com.app.service.FeesService;

@Service
@Transactional
public class FeesServiceImpl implements FeesService{
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private FeesDao feesDao;
	@Autowired
	private StudentDao studDao;
	
	@Override
	public List<Fees> getFeesList() {
		return feesDao.findAll();
	}
	@Override
	public Fees addFees(Long studId, FeesDto feesDto) {
		Fees feesEnt=mapper.map(feesDto, Fees.class);
		feesEnt.setStudent(studDao.findById(studId).orElseThrow());
		return feesDao.save(feesEnt);
	}
}
