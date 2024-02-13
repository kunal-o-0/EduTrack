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

import com.app.dto.attendance.AttendAddDto;
import com.app.dto.attendance.AttendGetDto;
import com.app.entities.secondary.Attendance;
import com.app.service.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private AttendanceService attendService;
	
	@GetMapping
	public List<AttendGetDto> getAttendList()
	{
		return attendService.getAttendList()
							.stream()
							.map((attendEnt)->
												{
													AttendGetDto attendDto=mapper.map(attendEnt, AttendGetDto.class);
													attendDto.setStudId(attendEnt.getStudent().getStudId());
													attendDto.setSchedId(attendEnt.getSchedule().getSchedId());
													return attendDto;
												})
							.collect(Collectors.toList());
	}
	
	@PostMapping("/{studId}/{schedId}")
	public void addAttend(@PathVariable("studId") Long studId,@PathVariable("schedId") Long schedId,@RequestBody AttendAddDto attendDto)
	{
		Attendance attendEnt=attendService.addAttend(studId, schedId, attendDto);
	}
}
