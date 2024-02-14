package com.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.HeadDao;
import com.app.dao.OrganizationDao;
import com.app.dto.organization.OrgDto;
import com.app.dto.organization.OrgAddHeadDto;
import com.app.entities.primary.Organization;
import com.app.service.OrganizationService;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService{
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private OrganizationDao orgDao;
	@Autowired
	private HeadDao headDao;
	
	@Override
	public Organization addOrganization(OrgDto org) {
		Organization orgEnt=mapper.map(org, Organization.class);
		return orgDao.save(orgEnt);
	}

	@Override
	public List<OrgDto> getOrgList() {
		return orgDao.findAll()
						.stream()
						.map((orgEnt)->
										{
											OrgDto orgDto=mapper.map(orgEnt, OrgDto.class);
											orgDto.setHeadId(orgEnt.getHead().getHeadId());
											return orgDto;
										})
						.collect(Collectors.toList());
	}

	@Override
	public Organization addHead(OrgAddHeadDto orgDto) {
		Organization orgEnt=orgDao.findById(orgDto.getOrgId()).orElseThrow();
		orgEnt.setHead(headDao.findById(orgDto.getHeadId()).orElseThrow());
		return orgEnt;
	}
}
