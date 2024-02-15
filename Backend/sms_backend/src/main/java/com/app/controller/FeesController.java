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

import com.app.dto.fees.FeesDto;
import com.app.entities.secondary.Fees;
import com.app.service.FeesService;
import com.app.util.ResponseText;

@RestController
@RequestMapping("/fees")
public class FeesController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private FeesService feesService;
	
	@GetMapping
	public List<FeesDto> getFeesList()
	{
		return feesService.getFeesList();
	}
	
	@PostMapping("/{studId}")
	public ResponseEntity<?> addFees(@PathVariable Long studId,@RequestBody FeesDto feesDto)
	{
		Fees feesEnt=feesService.addFees(studId, feesDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseText(HttpStatus.CREATED.value(),"Successfully created"));
	}
}
