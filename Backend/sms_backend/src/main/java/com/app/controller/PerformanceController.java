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
	
	@PostMapping
	public ResponseEntity<?> addPerfor(@RequestBody PerforDto perforDto)
	{
		Performance perforEnt=perforService.addPerfor(perforDto.getStudId(), perforDto.getSubId(), perforDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseText(HttpStatus.CREATED.value(),"Successfully created"));
	}
	
	@PutMapping("/{perforId}")
	public ResponseEntity<?> updatePerfor(@PathVariable @NotNull Long perforId,@RequestBody PerforDto perforDto)
	{
		Performance perforEnt=perforService.updatePerfor(perforId, perforDto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully updated"));
	}
	
	@DeleteMapping("/{perforId}")
	public ResponseEntity<?> deletePerfor(@PathVariable @NotNull Long perforId)
	{
		perforService.deletePerfor(perforId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully deleted"));
	}
}
