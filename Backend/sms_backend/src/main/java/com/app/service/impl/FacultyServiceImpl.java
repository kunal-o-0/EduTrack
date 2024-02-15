package com.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.FacultyDao;
import com.app.dao.OrganizationDao;
import com.app.dto.faculty.FacDto;
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
	public List<FacDto> getFacultyList() {
		return facDao.findAll()
						.stream()
						.map((facEnt)->
										{
											FacDto facDto=mapper.map(facEnt, FacDto.class);
											facDto.setOrgId(facEnt.getFacId());
											return facDto;
										})
						.collect(Collectors.toList());
	}
	
	@Override
	public Faculty addFaculty(Long orgId, FacDto facDto) {
		Faculty facEnt=mapper.map(facDto, Faculty.class);
		facEnt.setOrganization(orgDao.findById(orgId).orElseThrow());
		return facDao.save(facEnt);
	}

	@Override
	public Faculty updateFaculty(Long facId, FacDto facDto) {
		Faculty facOld=facDao.findById(facId).orElseThrow();
		Faculty facNew=mapper.map(facDto, Faculty.class);
		facNew.setFacId(facOld.getFacId());
		facNew.setOrganization(facOld.getOrganization());
		return facDao.save(facNew);
	}

	@Override
	public void deleteFaculty(Long facId) {
		facDao.deleteById(facId);
		facDao.flush();
	}
}
