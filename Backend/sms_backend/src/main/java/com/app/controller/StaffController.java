package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StaffAddDto;
import com.app.entities.primary.Staff;
import com.app.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private StaffService staffService;
	
	@GetMapping
	public List<StaffAddDto> getStaffList()
	{
		return staffService.getStaffList()
							.stream()
							.map((staffEnt)->{
												StaffAddDto staffDto=mapper.map(staffEnt, StaffAddDto.class);
												staffDto.setOrgId(staffEnt.getOrganization().getOrgId());
												return staffDto;
											})
							.collect(Collectors.toList());
	}
	
	@PostMapping("/{orgId}")
	public void addStaff(@PathVariable Long orgId,@RequestBody StaffAddDto staffDto)
	{
		Staff staffEnt= staffService.addStaff(orgId, staffDto);
	}
}
