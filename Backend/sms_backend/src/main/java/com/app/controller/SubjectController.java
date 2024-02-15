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

import com.app.dto.student.StudDto;
import com.app.dto.subject.SubDto;
import com.app.entities.secondary.Subject;
import com.app.service.SubjectService;
import com.app.util.ResponseText;

@RestController
@RequestMapping("/subject")
public class SubjectController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private SubjectService subService;
	
	@GetMapping
	public List<SubDto> getSubList()
	{
		return subService.getSubList();
	}
	
	@PostMapping("/{courseId}")
	public ResponseEntity<?> addSub(@PathVariable Long courseId,@RequestBody SubDto subDto)
	{
		Subject subEnt=subService.addSub(courseId, subDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseText(HttpStatus.CREATED.value(),"Successfully created"));
	}
	
	@PutMapping("/{subId}")
	public ResponseEntity<?> updateSub(@PathVariable @NotNull Long subId,@RequestBody SubDto subDto)
	{
		Subject subEnt=subService.updateSub(subId, subDto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully updated"));
	}
	
	@DeleteMapping("/{subId}")
	public ResponseEntity<?> deleteSub(@PathVariable @NotNull Long subId)
	{
		subService.deleteSub(subId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully deleted"));
	}
}
