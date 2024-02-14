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

import com.app.dto.course.CourseDto;
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
	public List<CourseDto> getCourseList()
	{
		return courseService.getCourseList();
	}
	
	@PostMapping
	public void addCourse(@RequestBody CourseDto courseDto)
	{
		courseService.addCourse(courseDto);
	}
}
