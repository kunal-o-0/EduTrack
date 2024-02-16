package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.attendance.AttendDto;
import com.app.dto.staff.StaffDto;
import com.app.entities.primary.Staff;
import com.app.service.StaffService;
import com.app.util.CreatePayload;
import com.app.util.ResponseText;

@RestController
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private StaffService staffService;
	
	@GetMapping
	public ResponseEntity<?> getStaffList()
	{
		return  ResponseEntity.status(HttpStatus.OK)
				.body(new CreatePayload<StaffDto>("Staff list",staffService.getStaffList())); 
	}
	
	@PostMapping
	public ResponseEntity<?> addStaff(@RequestBody StaffDto staffDto)
	{
		Staff staffEnt= staffService.addStaff(staffDto.getOrgId(), staffDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseText(HttpStatus.CREATED.value(),"Successfully created"));
	}
	
	@PutMapping("/{staffId}")
	public ResponseEntity<?> updateStaff(@PathVariable @NotNull Long staffId,@RequestBody StaffDto staffDto)
	{
		Staff staffEnt=staffService.updateStaff(staffId, staffDto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully updated"));
	}
	
	@DeleteMapping("/{staffId}")
	public ResponseEntity<?> deleteStaff(@PathVariable @NotNull Long staffId)
	{
		staffService.deleteStaff(staffId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully deleted"));
	}
}
