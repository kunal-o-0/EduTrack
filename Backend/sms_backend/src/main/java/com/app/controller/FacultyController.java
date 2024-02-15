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

import com.app.dto.faculty.FacDto;
import com.app.entities.primary.Faculty;
import com.app.service.FacultyService;
import com.app.util.ResponseText;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private FacultyService facService;
	
	@GetMapping
	public List<FacDto> getFacultyList()
	{
		return facService.getFacultyList();
	}
	
	@PostMapping("/{orgId}")
	public ResponseEntity<?> addFaculty(@PathVariable Long orgId,@RequestBody FacDto facDto)
	{
		Faculty facEnt=facService.addFaculty(orgId, facDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseText(HttpStatus.CREATED.value(),"Successfully created"));
	}
}
