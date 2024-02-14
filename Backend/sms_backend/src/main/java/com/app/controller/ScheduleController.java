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

import com.app.dto.schedule.SchedDto;
import com.app.entities.secondary.Schedule;
import com.app.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private ScheduleService schedService;
	
	@GetMapping
	public List<SchedDto> getSchedList()
	{
		return schedService.getSchedList();
	}
	
	@PostMapping("/{subId}")
	public void addSched(@PathVariable Long subId,@RequestBody SchedDto schedDto)
	{
		Schedule schedEnt=schedService.addSched(subId, schedDto);
	}
}
