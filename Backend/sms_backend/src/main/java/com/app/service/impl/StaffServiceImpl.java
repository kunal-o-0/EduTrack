package com.app.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.OrganizationDao;
import com.app.dao.StaffDao;
import com.app.dto.staff.StaffAfterLoginDto;
import com.app.dto.staff.StaffDto;
import com.app.dto.staff.StaffLoginDto;
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
	public List<StaffDto> getStaffList() {
		return staffDao.findAll()
						.stream()
						.map((staffEnt)->{
											StaffDto staffDto=mapper.map(staffEnt, StaffDto.class);
											staffDto.setOrgId(staffEnt.getOrganization().getOrgId());
											return staffDto;
										})
						.collect(Collectors.toList());
	}

	@Override
	public Staff addStaff(Long orgId,StaffDto staffDto) {
		Staff staffEnt=mapper.map(staffDto, Staff.class);
		staffEnt.setOrganization(orgDao.findById(orgId).orElseThrow());
		return staffDao.save(staffEnt);
	}

	@Override
	public Staff updateStaff(Long staffId, StaffDto staffDto) {
		Staff staffOld=staffDao.findById(staffId).orElseThrow();
		Staff staffNew=mapper.map(staffDto, Staff.class);
		staffNew.setStaffId(staffOld.getStaffId());
		staffNew.setOrganization(staffOld.getOrganization());
		return staffDao.save(staffNew);
	}

	@Override
	public void deleteStaff(Long staffId) {
		staffDao.deleteById(staffId);
		staffDao.flush();
	}

	@Override
	public StaffAfterLoginDto authenticateStaff(StaffLoginDto staffDto) throws NoSuchElementException{
		Staff staffEnt=staffDao.findByEmailPassword(staffDto.getEmail(), staffDto.getPassword()).orElseThrow();
		return mapper.map(staffEnt, StaffAfterLoginDto.class);
	}

}
