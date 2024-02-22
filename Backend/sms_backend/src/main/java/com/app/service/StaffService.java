package com.app.service;

import java.util.List;

import com.app.dto.staff.StaffAfterLoginDto;
import com.app.dto.staff.StaffDto;
import com.app.dto.staff.StaffLoginDto;
import com.app.entities.primary.Staff;

public interface StaffService {
	List<StaffDto> getStaffList();
	Staff addStaff(Long orgId,StaffDto staffDto);
	Staff updateStaff(Long staffId,StaffDto staffDto);
	void deleteStaff(Long staffId);
	
	StaffAfterLoginDto authenticateStaff(StaffLoginDto staffDto);
}
