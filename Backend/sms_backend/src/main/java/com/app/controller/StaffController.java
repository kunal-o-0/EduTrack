package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.staff.StaffDto;
import com.app.entities.primary.Staff;
import com.app.service.StaffService;
import com.app.util.ResponseText;

@RestController
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private StaffService staffService;
	
	@GetMapping
	public List<StaffDto> getStaffList()
	{
		return staffService.getStaffList();
	}
	
	@PostMapping("/{orgId}")
	public ResponseEntity<?> addStaff(@PathVariable Long orgId,@RequestBody StaffDto staffDto)
	{
		Staff staffEnt= staffService.addStaff(orgId, staffDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseText(HttpStatus.CREATED.value(),"Successfully created"));
	}
}
