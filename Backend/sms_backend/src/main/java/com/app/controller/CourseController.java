package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.course.CourseAddDto;
import com.app.dto.course.CourseGetDto;
import com.app.entities.secondary.Course;
import com.app.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public List<CourseGetDto> getCourseList()
	{
		return courseService.getCourseList()
							.stream()
							.map((courseEnt)->
												{
													CourseGetDto courseDto=mapper.map(courseEnt, CourseGetDto.class);
													return courseDto;
												})
							.collect(Collectors.toList());
	}
	
	@PostMapping
	public void addCourse(@RequestBody CourseAddDto courseDto)
	{
		courseService.addCourse(courseDto);
	}
}
