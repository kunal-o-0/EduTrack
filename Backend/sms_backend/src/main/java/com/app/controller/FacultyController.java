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

import com.app.dto.faculty.FacAddDto;
import com.app.dto.faculty.FacGetDto;
import com.app.entities.primary.Faculty;
import com.app.service.FacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private FacultyService facService;
	
	@GetMapping
	public List<FacGetDto> getFacultyList()
	{
		return facService.getFacultyList()
							.stream()
							.map((facEnt)->
											{
												FacGetDto facDto=mapper.map(facEnt, FacGetDto.class);
												facDto.setOrgId(facEnt.getFacId());
												return facDto;
											})
							.collect(Collectors.toList());
	}
	
	@PostMapping("/{orgId}")
	public void addFaculty(@PathVariable Long orgId,@RequestBody FacAddDto facDto)
	{
		Faculty facEnt=facService.addFaculty(orgId, facDto);
	}
}
