package com.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.FacultyDao;
import com.app.dao.OrganizationDao;
import com.app.dto.faculty.FacAddDto;
import com.app.entities.primary.Faculty;
import com.app.entities.primary.Organization;
import com.app.service.FacultyService;

@Service
@Transactional
public class FacultyServiceImpl implements FacultyService{
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private FacultyDao facDao;
	@Autowired
	private OrganizationDao orgDao;
	
	@Override
	public List<Faculty> getFacultyList() {
		return facDao.findAll();
	}
	
	@Override
	public Faculty addFaculty(Long orgId, FacAddDto facDto) {
		Faculty facEnt=mapper.map(facDto, Faculty.class);
		facEnt.setOrganization(orgDao.findById(orgId).orElseThrow());
		return facDao.save(facEnt);
	}
}
