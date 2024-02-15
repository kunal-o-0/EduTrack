package com.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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
	public List<FeesDto> getFeesList() {
		return feesDao.findAll()
						.stream()
						.map((feesEnt)->
											{
												FeesDto feesDto=mapper.map(feesEnt, FeesDto.class);
												feesDto.setStudId(feesEnt.getStudent().getStudId());
												return feesDto;
											})
						.collect(Collectors.toList());
	}
	
	@Override
	public Fees addFees(Long studId, FeesDto feesDto) {
		Fees feesEnt=mapper.map(feesDto, Fees.class);
		feesEnt.setStudent(studDao.findById(studId).orElseThrow());
		return feesDao.save(feesEnt);
	}

	@Override
	public Fees updateFees(Long feesId, FeesDto feesDto) {
		Fees feesOld=feesDao.findById(feesId).orElseThrow();
		Fees feesNew=mapper.map(feesDto, Fees.class);
		feesNew.setFeesId(feesOld.getFeesId());
		feesNew.setStudent(feesOld.getStudent());
		return feesDao.save(feesNew);
	}

	@Override
	public void deleteFees(Long feesId) {
		feesDao.deleteById(feesId);
		feesDao.flush();
	}
}
