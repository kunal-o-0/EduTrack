package com.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.OrganizationDao;
import com.app.dto.OrgAddDto;
import com.app.entities.primary.Organization;
import com.app.service.OrganizationService;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService{
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private OrganizationDao orgDao;
	
	@Override
	public Organization addOrganization(OrgAddDto org) {
		Organization orgEnt=mapper.map(org, Organization.class);
		return orgDao.save(orgEnt);
	}

	@Override
	public List<Organization> getOrgList() {
		return orgDao.findAll();
	}
}
