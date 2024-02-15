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
import com.app.entities.secondary.Attendance;
import com.app.service.AttendanceService;
import com.app.util.ResponseText;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private AttendanceService attendService;
	
	@GetMapping
	public List<AttendDto> getAttendList()
	{
		return attendService.getAttendList();
	}
	
	@PostMapping
	public ResponseEntity<?> addAttend(@RequestBody AttendDto attendDto)
	{
		Attendance attendEnt=attendService.addAttend(attendDto.getStudId(), attendDto.getSchedId(), attendDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseText(HttpStatus.CREATED.value(),"Successfully created"));
	}
	
	@PutMapping("/{attendId}")
	public ResponseEntity<?> updateAttend(@PathVariable @NotNull Long attendId,@RequestBody AttendDto attendDto)
	{
		Attendance attendEnt=attendService.updateAttend(attendId, attendDto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully updated"));
	}
	
	@DeleteMapping("/{attendId}")
	public ResponseEntity<?> deleteAttend(@PathVariable @NotNull Long attendId)
	{
		attendService.deleteAttend(attendId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully deleted"));
	}
}
