package com.app.service;

import java.util.List;

import com.app.dto.staff.StaffDto;
import com.app.entities.primary.Staff;

public interface StaffService {
	List<Staff> getStaffList();
	
	Staff addStaff(Long orgId,StaffDto staffDto);
}
