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

import com.app.dto.student.StudDto;
import com.app.entities.primary.Student;
import com.app.service.CourseService;
import com.app.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private StudentService studService;
	
	@GetMapping
	public List<StudDto> getStudentList()
	{
		return studService.getStudentList()
							.stream()
							.map((studEnt)->
											{
												StudDto studDto=mapper.map(studEnt, StudDto.class);
												studDto.setOrgId(studEnt.getOrganization().getOrgId());
												studDto.setCourseId(studEnt.getCourse().getCourseId());
												return studDto;
											})
							.collect(Collectors.toList());
	}
	
	@PostMapping("/{orgId}/{courseId}")
	public void addStudent(@PathVariable("orgId") Long orgId,@PathVariable("courseId") Long courseId, @RequestBody StudDto studDto)
	{
		Student studEnt=studService.addStudent(orgId,courseId, studDto);
	}
}
