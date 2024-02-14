package com.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.HeadDao;
import com.app.dao.OrganizationDao;
import com.app.dto.head.HeadDto;
import com.app.entities.primary.Head;
import com.app.entities.primary.Organization;
import com.app.service.HeadService;

@Service
@Transactional
public class HeadServiceImpl implements HeadService{
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private HeadDao headDao;
	@Autowired
	private OrganizationDao orgDao;
	
	@Override
	public List<Head> getHeadList() {
		return headDao.findAll();
	}
	
	@Override
	public Head addHead(Long orgId, HeadDto headDto) {
		Head headEnt=mapper.map(headDto, Head.class);
		Organization orgEnt= orgDao.findById(orgId).orElseThrow();
		orgEnt.setHead(headEnt);
		return headDao.save(headEnt);
	}	
}
