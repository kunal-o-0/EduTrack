package com.app.service;

import java.util.List;

import com.app.dto.staff.StaffAddDto;
import com.app.entities.primary.Staff;

public interface StaffService {
	List<Staff> getStaffList();
	
	Staff addStaff(Long orgId,StaffAddDto staffDto);
}
