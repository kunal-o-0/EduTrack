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
import com.app.dto.schedule.SchedDto;
import com.app.entities.secondary.Schedule;
import com.app.service.ScheduleService;
import com.app.util.CreatePayload;
import com.app.util.ResponseText;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private ScheduleService schedService;
	
	@GetMapping
	public ResponseEntity<?> getSchedList()
	{
		return  ResponseEntity.status(HttpStatus.OK)
				.body(new CreatePayload<SchedDto>("Schedule list",schedService.getSchedList())); 
	}
	
	@PostMapping
	public ResponseEntity<?> addSched(@RequestBody SchedDto schedDto)
	{
		Schedule schedEnt=schedService.addSched(schedDto.getSubId(), schedDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseText(HttpStatus.CREATED.value(),"Successfully created"));
	}
	
	@PutMapping("/{schedId}")
	public ResponseEntity<?> updateSched(@PathVariable @NotNull Long schedId,@RequestBody SchedDto schedDto)
	{
		Schedule schedEnt=schedService.updateSched(schedId, schedDto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully updated"));
	}
	
	@DeleteMapping("/{schedId}")
	public ResponseEntity<?> deleteSched(@PathVariable @NotNull Long schedId)
	{
		schedService.deleteSched(schedId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully deleted"));
	}
}
