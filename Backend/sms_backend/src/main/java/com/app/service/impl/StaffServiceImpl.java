package com.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.OrganizationDao;
import com.app.dao.StaffDao;
import com.app.dto.staff.StaffDto;
import com.app.entities.primary.Staff;
import com.app.service.StaffService;

@Service
@Transactional
public class StaffServiceImpl implements StaffService{
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private StaffDao staffDao;
	@Autowired OrganizationDao orgDao;
	
	
	@Override
	public List<Staff> getStaffList() {
		return staffDao.findAll();
	}

	@Override
	public Staff addStaff(Long orgId,StaffDto staffDto) {
		Staff staffEnt=mapper.map(staffDto, Staff.class);
		staffEnt.setOrganization(orgDao.findById(orgId).orElseThrow());
		return staffDao.save(staffEnt);
	}

}
