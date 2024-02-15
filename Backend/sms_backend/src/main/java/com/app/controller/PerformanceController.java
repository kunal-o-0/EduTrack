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

import com.app.dto.performance.PerforDto;
import com.app.entities.secondary.Performance;
import com.app.service.PerformanceService;
import com.app.util.ResponseText;

@RestController
@RequestMapping("/performance")
public class PerformanceController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private PerformanceService perforService;
	
	@GetMapping
	public List<PerforDto> getPerforList()
	{
		return perforService.getPerforList();
	}
	
	@PostMapping("/{studId}/{subId}")
	public ResponseEntity<?> addPerfor(@PathVariable("studId") Long studId,@PathVariable("subId") Long subId,@RequestBody PerforDto perforDto)
	{
		Performance perforEnt=perforService.addPerfor(studId, subId, perforDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseText(HttpStatus.CREATED.value(),"Successfully created"));
	}
}
