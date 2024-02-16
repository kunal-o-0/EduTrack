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
import com.app.dto.fees.FeesDto;
import com.app.entities.secondary.Fees;
import com.app.service.FeesService;
import com.app.util.CreatePayload;
import com.app.util.ResponseText;

@RestController
@RequestMapping("/fees")
public class FeesController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private FeesService feesService;
	
	@GetMapping
	public ResponseEntity<?> getFeesList()
	{
		return  ResponseEntity.status(HttpStatus.OK)
				.body(new CreatePayload<FeesDto>("Fees list",feesService.getFeesList()));
	}
	
	@PostMapping
	public ResponseEntity<?> addFees(@RequestBody FeesDto feesDto)
	{
		Fees feesEnt=feesService.addFees(feesDto.getStudId(), feesDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseText(HttpStatus.CREATED.value(),"Successfully created"));
	}
	
	@PutMapping("/{feesId}")
	public ResponseEntity<?> updateFees(@PathVariable @NotNull Long feesId,@RequestBody FeesDto feesDto)
	{
		Fees feesEnt=feesService.updateFees(feesId, feesDto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully updated"));
	}
	
	@DeleteMapping("/{feesId}")
	public ResponseEntity<?> deleteFees(@PathVariable @NotNull Long feesId)
	{
		feesService.deleteFees(feesId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully deleted"));
	}
}
